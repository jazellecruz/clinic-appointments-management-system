package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.database.Database;
import main.java.models.Doctor;
import main.java.models.Admin;


/* INCOMPLETE CODE - WILL BE FURTHER REFACTORED. */

public class LoginDAO {
    public static Doctor checkIfDoctorExists(String email, String password) throws SQLException{
        Connection con = Database.getDbConnection();
        String query = "SELECT * FROM doctors d LEFT JOIN specs s ON s.spec_id = d.spec_id WHERE email = ?";
        Doctor doctor = new Doctor();

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                String user_password = res.getString("password");

                if(user_password.equals(password)) {
                    doctor.setDoctorId(res.getInt("doctor_id"));
                    doctor.setName(res.getString("doctor_name"));
                    doctor.setSpecializationName(res.getString("spec_name"));
                    doctor.setSpecId(res.getInt("spec_id"));
                    doctor.setImgRef(res.getString("image_ref"));
                    doctor.setIsAuthenticated(true);
                }

            } else {
                doctor.setIsAuthenticated(false);
            }
        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        return doctor;
    }
    
    public static Admin checkIfAdminExists(String email, String password) throws SQLException {
        Connection con = Database.getDbConnection();
        String query = "SELECT * FROM admin_users WHERE email = ?;";
        Admin admin = new Admin();
        
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet res = stmt.executeQuery();

            if(res.next()){
                String user_password = res.getString("password");

                if(user_password.equals(password)) {
                    admin.setAdminId(res.getInt("admin_id"));
                    admin.setEmail(res.getString("email"));
                    admin.setIsAuthenticated(true);
                }

            } else {
                admin.setIsAuthenticated(false);
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        
        return admin;
    }
    
}
