
/* INCOMPLETE CODE - WILL BE FURTHER EDITED */

package main.java.views;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

import javax.swing.table.AbstractTableModel;
import main.java.models.Appointment;
import main.java.utils.Utils;


public class ApptTableModel extends AbstractTableModel {
    private Comparator<Appointment> comparator;
    private Predicate<Appointment> filter;
    private ArrayList<Appointment> apptsList;
    private ArrayList<Appointment> origApptData;
    private String[] columnNames;
    
    public ApptTableModel(ArrayList<Appointment> appts, String[] colNames) {
        this.apptsList = appts;
        this.origApptData = new ArrayList<>(appts);
        this.columnNames = colNames;
        this.filter = null;
        this.comparator = null;

    }

  
    @Override
    public String getColumnName(int columnIndex){
        return columnNames[columnIndex];
    }
    
    @Override
    public int getRowCount() {
        return apptsList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appt = apptsList.get(rowIndex);
        String colName =  getColumnName(columnIndex);

        switch (colName) {
            case "Appointment ID" :
                return appt.getApptId();
            case "Patient" :
                return appt.getPatient().getName();
            case "Doctor" :
                return appt.getDoctor().toString();
            case "Visit Type" :
                return appt.getVisitTypeName();
            case "Date" :
                return Utils.formatDate(appt.getDate()); 
            case "Time" :
                String startTime = Utils.convertTimeFormat(appt.getStartTime());
                String endTime = Utils.convertTimeFormat(appt.getEndTime());
                    
                return startTime + " - " + endTime;
            case "Status" :
                return appt.getStatus();
            default:
                return null;
            }             
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == (columnNames.length - 1)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == (columnNames.length - 1)) {
            return String.class; 
        }
        
        return super.getColumnClass(columnIndex);
    }
    
    
    public void setValueAt(Object value, int row, boolean updateStatus) {
        if (updateStatus) {
            apptsList.get(row).setStatus(value.toString());
            fireTableCellUpdated(row, (columnNames.length - 1));
        }
    }
    
    public void updateTable(Appointment appt) {
   
    }
    
    

    public void setFilter(Predicate<Appointment> filter) {
        this.filter = filter;
        filterData();
    }

    public void setComparator(Comparator<Appointment> comparator) {
        this.comparator = comparator;
        sortData();
    }

    private void filterData() {
        if (filter != null) {
            apptsList.clear();
            apptsList.addAll(origApptData);
            apptsList.removeIf(filter.negate());
            fireTableDataChanged();
        }
    }

    private void sortData() {
        if (comparator != null) {
            apptsList.sort(comparator);
            fireTableDataChanged();
        }
    }
    
    public void setToOriginalState() {
        apptsList.clear();
        apptsList.addAll(origApptData);
        
        fireTableDataChanged();
    }
    
    /* This method retrieves the correct appointment regardless of the rows being filtered or not */
    public Appointment getSelectedRowValue(int rowIndex) {
        return apptsList.get(rowIndex); 
    }
    
    public void updateOriginalTableData(ArrayList<Appointment> appts) {
        this.origApptData = new ArrayList<>(appts);
    }
    
}

