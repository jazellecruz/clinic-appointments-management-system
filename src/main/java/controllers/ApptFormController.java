
package main.java.controllers;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import main.java.dao.AppointmentDAO;
import main.java.dao.DoctorDAO;
import main.java.dao.PatientDAO;
import main.java.models.Appointment;
import main.java.models.Doctor;
import main.java.models.Schedule;
import main.java.models.Specialization;
import main.java.models.VisitType;
import main.java.utils.Utils;
import main.java.views.ApptFormView;

public class ApptFormController {
    private ApptFormView view;
    private AdminController adminController;
    private boolean isPatientNew;
    
    private ArrayList<Specialization> specsList;
    private ArrayList<VisitType> visitTypesList;
    private ArrayList<Doctor> doctorsList;
    private ArrayList<Schedule> docSchedulesList;
    
    private DefaultComboBoxModel<VisitType> visitTypeComboBoxModel;
    private DefaultComboBoxModel<Specialization> specComboBoxModel;
    
    private static final int INITIAL_APPT_STATUS_ID = 1;
    
    public ApptFormController(ApptFormView view, AdminController adminController, boolean isPatientNew) {
        this.view = view;
        this.adminController = adminController;
        this.isPatientNew = isPatientNew;
        
        // Retrieve data that will be used in the Apptointment Form 
        try {
            this.specsList = DoctorDAO.getAllDoctorSpecializations();
            this.visitTypesList = AppointmentDAO.getAllVisitTypes();
        } catch (SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        // Create models for the components
        this.visitTypeComboBoxModel = new DefaultComboBoxModel(this.visitTypesList.toArray());
        this.specComboBoxModel = new DefaultComboBoxModel(this.specsList.toArray());
       
        // Set components' their respective models
        this.view.getSpecComboBox().setModel(specComboBoxModel);
        this.view.getVisitTypeComboBox().setModel(visitTypeComboBoxModel);

 
        // Set the components' event listeners
        
        /** 
         * Note:
         * ActionListener is used instead of ItemListener. Some Combo Boxes 
         * may contain only one item and automatically sets the item as the
         * selected value. ItemListener listens for selection changes only. 
         * Even if the user clicks the already selected item from the combo box, 
         * it will not trigger the listener since the selection state did not change.
         * ActionListener is more appropriate to use in this case.
         */
        this.view.getSpecComboBox().addActionListener((ActionEvent e) -> { loadDoctorsIntoComboBox(); });
        this.view.getDocComboBox().addActionListener((ActionEvent e) -> { loadDoctorSchedsIntoComboBox(); });
        this.view.getAddBtn().addActionListener((ActionEvent e) -> { addNewAppt(); });
        
        this.view.setVisible(true);
    }
    
    private void loadDoctorSchedsIntoComboBox() {
        int id = ((Doctor) view.getDocComboBox().getSelectedItem()).getDoctorId();

        try{
            docSchedulesList = DoctorDAO.getDoctorSchedules(id);
            view.getSchedComboBox().setModel(new DefaultComboBoxModel(docSchedulesList.toArray()));
        } catch(SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void loadDoctorsIntoComboBox() {
        int id = ((Specialization) view.getSpecComboBox().getSelectedItem()).getSpecId();
        
        try {
            doctorsList = DoctorDAO.getDoctorBySpecialization(id);            
            view.getDocComboBox().setModel(new DefaultComboBoxModel(doctorsList.toArray()));
        } catch (SQLException e) {
            this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void addNewAppt() {
        Appointment appt;
        
        int dayNum = ((Schedule) this.view.getSchedComboBox().getSelectedItem()).getDay();
        int doctorId = ((Doctor) this.view.getDocComboBox().getSelectedItem()).getDoctorId();
        int visitTypeId = ((VisitType) this.view.getVisitTypeComboBox().getSelectedItem()).getVisitTypeId();

       String startTime = ((Schedule) this.view.getSchedComboBox().getSelectedItem()).getStartTime();
       String endTime = ((Schedule) this.view.getSchedComboBox().getSelectedItem()).getEndTime();
       String dayName = Utils.convertIntToDay(dayNum);

       // Get the date of the new appt based on the chosen day
       String dateOfNewAppt = Utils.getNextDateOfDay(dayName);
       
       try{
           
            if (isPatientNew) {
                String name = this.view.getNameFieldValue();
                int age = this.view.getAgeFieldValue();
                String sex = this.view.getSexComboBoxValue();

                System.out.println(name);
                System.out.println(age);
                System.out.println(sex);

                // Register first the new patient to the database then return its id.
                int idOfNewPatient = PatientDAO.addNewPatient(name, age, sex).getPatientId();

                appt = AppointmentDAO.addNewAppt(doctorId, idOfNewPatient, startTime, endTime, dateOfNewAppt, visitTypeId, INITIAL_APPT_STATUS_ID);
            } else {
                int patientId = Integer.parseInt(view.getPatientIdField().getText());
                appt = AppointmentDAO.addNewAppt(doctorId, patientId, startTime, endTime, dateOfNewAppt, visitTypeId, INITIAL_APPT_STATUS_ID);
            }

            if (appt != null) {
                view.showMessageBox( "Successfully added new appointment!", "Success", JOptionPane.PLAIN_MESSAGE);

                this.adminController.addNewApptToTable(appt);
             } else {
                view.showMessageBox("Failed to add new appointment!", "Error", JOptionPane.ERROR_MESSAGE);
            }
       } catch(SQLException e){
           this.view.showMessageBox(e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
    }
    
}
