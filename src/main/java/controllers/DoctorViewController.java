package main.java.controllers;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

import main.java.dao.AppointmentDAO;
import main.java.dao.DoctorDAO;
import main.java.models.Appointment;
import main.java.models.Doctor;
import main.java.models.Status;
import main.java.views.ApptTableModel;
import main.java.views.ApptWindowView;
import main.java.views.DoctorView;
import main.java.views.LoginView;
import main.java.views.StatusCellRenderer;

public class DoctorViewController {
    private DoctorView view;
    
    private Doctor currentDoc;
    
    private ArrayList<Appointment> apptsList;
    private ArrayList<Status> statusTypesList;
    
    private ApptTableModel tableModel;
    private DefaultComboBoxModel statusColModel;
    
    private final String[] COLUMN_NAMES = {"Appointment ID", "Patient", "Visit Type", "Date", "Time", "Status"};
    private final int STATUS_COL_IND = 5;
    private final int APPT_ID_COL_IND = 0;
    private final int PATIENT_NAME_COL_IND = 1;
    
    
    public DoctorViewController(DoctorView view, Doctor doctor) {
        this.view = view;
        this.currentDoc = doctor;
        
        // Retrieve data that will be used in the DoctorView
        try{
            apptsList = AppointmentDAO.getAllApptsByDoctor(currentDoc.getDoctorId());
            statusTypesList = AppointmentDAO.getAllStatusTypes(); 
        } catch(SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        tableModel = new ApptTableModel(apptsList, COLUMN_NAMES);
        statusColModel = new DefaultComboBoxModel(statusTypesList.toArray());

        view.getApptTable().setModel(tableModel);
        view.getStatusTypeComboBox().setModel(statusColModel);

        TableColumn statusCol = view.getApptTable().getColumnModel().getColumn(STATUS_COL_IND);
        statusCol.setCellEditor(new DefaultCellEditor(view.getStatusTypeComboBox()));
        
        StatusCellRenderer cellRenderer = new StatusCellRenderer();
        statusCol.setCellRenderer(cellRenderer);
        
        view.setProfileForCurrentUser(currentDoc.getName(), currentDoc.getSpecializationName(), currentDoc.getImgRef());
        
        // Add behaviors of the component
        view.getStatusTypeComboBox().addActionListener((ActionEvent e) -> { updateApptStatus(); });
        view.getFilterComboBox().addActionListener((ActionEvent e) -> { filterApptsTable(); } );
        view.getLogoutBtn().addActionListener((ActionEvent e) -> { logoutUser(); });
        view.getApptTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){ handleTableMouseClick(e); };
        });
        
        view.setVisible(true);
    }
    
    
    void updateApptStatus() {
        int selRow = view.getApptTable().getEditingRow();
        
        // You can parse the string to int instead of casting
        int apptId = (int) view.getApptTable().getValueAt(selRow, APPT_ID_COL_IND);  // 
                
        try {
            String msg = "Do you want to update appointment status for " + view.getApptTable().getValueAt(selRow, PATIENT_NAME_COL_IND).toString();
            boolean isConfirmed = view.showConfirmBox(msg, "Confirm Status Update");
            
            if (isConfirmed){
                Status selStat = (Status) view.getStatusTypeComboBox().getSelectedItem();
            
                boolean isUpdateSuccessful = AppointmentDAO.updateApptStatus(selStat.getStatusId(), apptId);
            
                if(isUpdateSuccessful) {
                    tableModel.setValueAt(selStat.getStatusName(), selRow, true);
                    view.showMessageBox("Successfully updated appointment!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    view.showMessageBox("Update failed! Appointment with ID #" + apptId + " does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
        } catch (SQLException e) {
            view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
    }
    
    void logoutUser() {
        boolean isConfirmed = view.showConfirmBox("Are you sure you want to logout?", "Confirm Logout");
        
        if(isConfirmed) {
            this.view.dispose();
            LoginView loginView = new LoginView();
            new LoginController(loginView);
        }     
    }
    
    public static void main(String[] args)  {


        try {
                        DoctorView view = new DoctorView();
           Doctor doc = DoctorDAO.getDoctorById(1);
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                    new DoctorViewController(view, doc);
            }
        });
        } catch (SQLException e) {
            e.printStackTrace();
        }
      

    }
}
