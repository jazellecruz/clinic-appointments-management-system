package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.database.Database;
import main.java.models.Patient;


/* INCOMPLETE CODE - WILL BE FURTHER REFACTORED. */

public class PatientDAO {

    public static Patient getPatientById(int id) throws SQLException{
        Connection con = Database.getDbConnection();
        Patient patient = new Patient();
        String query = "SELECT * FROM patients WHERE patient_id = ? ;";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if(res.next()) {
                patient.setName(res.getString("patient_name"));
                patient.setAge(res.getInt("patient_age"));
                patient.setSex(res.getString("patient_sex"));
                patient.setPatientId(res.getInt("patient_id"));               
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return patient;
    }

    public static Patient addNewPatient(String name, int age, String sex) throws SQLException{
        Connection con = Database.getDbConnection();
        Patient patient = null;
        String query = "INSERT INTO patients (patient_name, patient_age, patient_sex) VALUES (?, ?, ?);";

        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, sex);
            int rowsAffected = stmt.executeUpdate();
            
            if(rowsAffected > 0) {
                ResultSet patientId = stmt.executeQuery("SELECT LAST_INSERT_ID() AS last_id;");

                if(patientId.next()) patient = getPatientById(patientId.getInt("last_id"));
            } 
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return patient;
    }   

}