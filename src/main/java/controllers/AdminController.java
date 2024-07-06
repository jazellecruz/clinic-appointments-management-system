
package main.java.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

import main.java.dao.AppointmentDAO;
import main.java.models.Appointment;
import main.java.models.Status;
import main.java.views.AdminView;
import main.java.views.ApptFormView;
import main.java.views.ApptTableModel;
import main.java.views.ApptWindowView;
import main.java.views.LoginView;
import main.java.views.StatusCellRenderer;


public class AdminController {
    private AdminView view;
    
    private ArrayList<Status> statusTypesList;
    private ArrayList<Appointment> apptsList;
    
    private ApptTableModel tableModel;
    private DefaultComboBoxModel statusColModel;
    
    private final String[] COLUM_NAMES = {"Appointment ID", "Patient", "Doctor", "Visit Type", "Date", "Time", "Status"};
    private final int APPT_ID_COL_IND = 0;
    private final int PATIENT_NAME_COL_IND = 1;
    private final int STATUS_COL_IND = 6;
    
    public AdminController(AdminView view){
        this.view = view;
        
        // Retrieve data that will be used in the AdminView 
        try{
            this.statusTypesList = AppointmentDAO.getAllStatusTypes();
            this.apptsList = AppointmentDAO.getAllAppts();
        } catch(SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        
        // Create the models for the components 
        this.tableModel = new ApptTableModel(apptsList, COLUM_NAMES);
        this.statusColModel = new DefaultComboBoxModel(statusTypesList.toArray());

        // Set the components' models 
        view.getApptTable().setModel(tableModel);
        view.getStatusTypeComboBox().setModel(statusColModel);
         
        // Set the status column of the table into a combo box for status editing 
        TableColumn statusCol = view.getApptTable().getColumnModel().getColumn(STATUS_COL_IND); 
        statusCol.setCellEditor(new DefaultCellEditor(view.getStatusTypeComboBox()));
        
        // Set the cell renderer for the status column (colors the text based on status)
        StatusCellRenderer cellRenderer = new StatusCellRenderer();
        statusCol.setCellRenderer(cellRenderer);
        
        // Add behaviors to our components 
        view.getAddNewApptBtn().addActionListener((ActionEvent e) -> { openApptForm(); });
        view.getStatusTypeComboBox().addActionListener((ActionEvent e) -> { updateApptStatus(); });
        view.getDelBtn().addActionListener((ActionEvent e) -> { deleteAppts(); });
        view.getFilterComboBox().addActionListener((ActionEvent e) -> { filterApptsTable(); } );
        view.getLogoutBtn().addActionListener((ActionEvent e) -> { logoutUser(); });
        view.getApptTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){ handleTableMouseClick(e); };
        });
        
        view.setVisible(true);
    }
    
    void openApptForm() {
        String str = view.showStatusPatientBox();
        
        /* NOTE:
         * "else if" is used for checking the other option and NOT "else" 
        * to avoid opening the form if the user decides to close the dialog box.
        */
        if(str.equals("New")) {
            ApptFormView formView = new ApptFormView(true);
            new ApptFormController(formView, this, true);
        } else if (str.equals("Existing")) {
            ApptFormView formView = new ApptFormView(false);
            new ApptFormController(formView, this, false);
        } else {
            return;
        }
    }
    
    void filterApptsTable() {
        String selVal = view.getFilterComboBox().getSelectedItem().toString();
        Predicate<Appointment> predicate = null;
        
        switch (selVal) {
            case "Pending": 
                predicate = appointment -> appointment.getStatus().equals("Pending");
                break;
            case "Completed" :
                predicate = appointment -> appointment.getStatus().equals("Completed");
                break;
            case "Confirmed":
                predicate = appointment -> appointment.getStatus().equals("Confirmed");
                break;
            case "Canceled":
                predicate = appointment -> appointment.getStatus().equals("Canceled");
                break;
            case "Default":
                tableModel.setToOriginalState();
                break;
        }
        
        tableModel.setFilter(predicate);
    }
    
    void updateApptStatus() {
        int selRow = view.getApptTable().getEditingRow();
        
        // You can parse the string to int instead of casting
        int apptId = (int) view.getApptTable().getValueAt(selRow, APPT_ID_COL_IND);  // 
        String msg = "Update appointment for " + view.getApptTable().getValueAt(selRow, PATIENT_NAME_COL_IND).toString() + "?";
        
        try {
            boolean isConfirmed = this.view.showConfirmBox(msg, "Confirm Update");
            if (isConfirmed){
                Status selStat = (Status) view.getStatusTypeComboBox().getSelectedItem();
            
                boolean isUpdateSuccessful = AppointmentDAO.updateApptStatus(selStat.getStatusId(), apptId);
            
                if(isUpdateSuccessful) {
                    tableModel.setValueAt(selStat.getStatusName(), selRow, true);
                    view.showMessageBox("Successfully updated appointment!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    view.showMessageBox("Update failed! Appointment with ID #" + apptId + " does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
        } catch (SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    void deleteAppts() {
        ArrayList<Integer> apptIds = new ArrayList<>();
        int[] selRows = view.getApptTable().getSelectedRows();
        
        for (int i : selRows) {
            apptIds.add(tableModel.getSelectedRowValue(i).getApptId());
        } 
        
        try {
            boolean isDeletionSuccessful = AppointmentDAO.deleteMulApptById(apptIds);
            
            if (isDeletionSuccessful) {
                for (int i = 0; i < selRows.length; i++) {
                    if ( i == 0) {
                        apptsList.remove(selRows[i]);
                    } else {
                        apptsList.remove(selRows[i] - i);
                    }
                }
            
                /** 
                 * Update the table's original copy of the data for accurate
                 * filtering then update the table 
                 */
                tableModel.updateOriginalTableData(apptsList);
                tableModel.fireTableDataChanged();
            
                this.view.showMessageBox("Successfully deleted appointments!", "Success",  JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.view.showMessageBox("Deletion failed! Appointment/s does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            }  
        } catch (SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error",  JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    void handleTableMouseClick(MouseEvent e) {
        JTable table = (JTable) e.getSource();
        Point point = e.getPoint();
        
        int row = table.rowAtPoint(point);
        int modelRow = table.convertRowIndexToModel(row); 
        
        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            if (row >= 0) {
                Appointment appt = tableModel.getSelectedRowValue(modelRow); 
                new ApptWindowView(appt);
            }
        }
        
        if (SwingUtilities.isRightMouseButton(e)) {
            if (row >= 0) {
                int apptId = tableModel.getSelectedRowValue(row).getApptId();
                
                // Note to self: The table variable holds the reference to the orig table.
                this.view.getApptPopupMenu().show(table, e.getX(), e.getY());
            }
        }
    }
    
    void logoutUser() {
        boolean isConfirmed = this.view.showConfirmBox("Are you sure you want to logout?", "Confirm Logout");
        
        if(isConfirmed) {
            this.view.dispose();
            LoginView loginView = new LoginView();
            new LoginController(loginView);
        }
    }
    
    public void addNewApptToTable(Appointment appt) {
        apptsList.add(0, appt);
        tableModel.fireTableRowsInserted(0, 0);
    }
 
    
}

/**REFERENCES/DOCS:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JTable.html
 * 
 */
