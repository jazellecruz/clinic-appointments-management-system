package main.java.controllers;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import main.java.dao.LoginDAO;
import main.java.models.Admin;
import main.java.models.Doctor;
import main.java.views.AdminView;
import main.java.views.DoctorView;
import main.java.views.LoginView;

public class LoginController {
    private LoginView view;
    
    public LoginController(LoginView view) {
        this.view = view;
        
        view.getLoginBtn().addActionListener((ActionEvent e) -> { authenticateUser(); });
        
        view.setVisible(true);
    }
    
    void authenticateUser(){
        String email = view.getEmailField().getText();
        String password = new String(view.getPasswordField().getPassword());
        String role = view.getRoleBoxOpts().getSelectedItem().toString();
        
        try{
            if(role.equalsIgnoreCase("Doctor")) {
            Doctor doctor = LoginDAO.checkIfDoctorExists(email, password);
            
            if(doctor.getAuthenticationStatus()) {
                DoctorView doctorView = new DoctorView();
                new DoctorViewController(doctorView, doctor);
                this.view.dispose();
            } else {
                this.view.showInvalidUserMessage();
            }
        }
        
            if(role.equalsIgnoreCase("Admin")) {
                Admin admin = LoginDAO.checkIfAdminExists(email, password);

                if(admin.isAuthenticated()) {
                    AdminView adminView = new AdminView();
                    new AdminController(adminView);
                    this.view.dispose();
                } else {
                    this.view.showInvalidUserMessage();
                }
            } 
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
