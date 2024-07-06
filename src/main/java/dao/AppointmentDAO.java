package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.database.Database;
import main.java.models.Appointment;
import main.java.models.Patient;
import main.java.models.Doctor;
import main.java.models.VisitType;
import main.java.models.Status;

/* INCOMPLETE CODE - WILL BE FURTHER REFACTORED. */

public class AppointmentDAO {

    public static ArrayList getAllAppts() throws SQLException {
        Connection con = Database.getDbConnection();
        
        ArrayList<Appointment> appts = new ArrayList<Appointment>();
        
        Appointment appt = null;
        Patient patient = null;
        Doctor doctor = null;
        String query = "SELECT a.patient_id, patient_name, patient_age, patient_sex, "
                + "a.doctor_id, doctor_name, image_ref, d.spec_id, sp.spec_name, "
                + "a.visit_type_id, v.visit_type_name, "
                + "a.status_id, s.status_name, "
                + "appt_id, start_time, end_time, appt_date FROM appointments a "
                + "LEFT JOIN doctors d ON a.doctor_id = d.doctor_id "
                + "LEFT JOIN patients p ON a.patient_id = p.patient_id "
                + "LEFT JOIN visit_type v ON a.visit_type_id = v.visit_type_id " 
                + "LEFT JOIN status s ON a.status_id = s.status_id "
                + "LEFT JOIN specs sp ON d.spec_id = sp.spec_id "
                + "ORDER BY appt_id DESC;";
        
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()) {

                patient = new Patient(res.getString("patient_name"),
                res.getInt("patient_age"),
                res.getString("patient_sex"),
                res.getInt("patient_id"));

                doctor = new Doctor(res.getInt("doctor_id"),
                res.getString("doctor_name"),
                res.getString("spec_name"),
                res.getInt("spec_id"),
                res.getString("image_ref"));

                appt = new Appointment(patient, 
                        doctor,
                        res.getInt("appt_id"),
                        res.getString("start_time"),
                        res.getString("end_time"),
                        res.getString("appt_date"),
                        res.getString("visit_type_name"),
                        res.getInt("visit_type_id"),
                        res.getString("status_name"),
                        res.getInt("status_id"));
                
                appts.add(appt);
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        
        return appts;
    }
    
    public static Appointment getApptById(int id) throws SQLException{
        Connection con = Database.getDbConnection();
        Appointment appt = null;
        Patient patient = null;
        Doctor doctor = null;
        String query = "SELECT a.patient_id, patient_name, patient_age, patient_sex, "
                + "a.doctor_id, doctor_name, image_ref, d.spec_id, sp.spec_name, "
                + "a.visit_type_id, v.visit_type_name, "
                + "a.status_id, s.status_name, "
                + "appt_id, start_time, end_time, appt_date FROM appointments a "
                + "LEFT JOIN doctors d ON a.doctor_id = d.doctor_id "
                + "LEFT JOIN patients p ON a.patient_id = p.patient_id "
                + "LEFT JOIN visit_type v ON a.visit_type_id = v.visit_type_id " 
                + "LEFT JOIN status s ON a.status_id = s.status_id "
                + "LEFT JOIN specs sp ON d.spec_id = sp.spec_id "
                + "WHERE a.appt_id = ? ;";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            
            if(res.next()) {
                patient = new Patient(res.getString("patient_name"),
                res.getInt("patient_age"),
                res.getString("patient_sex"),
                res.getInt("patient_id"));

                doctor = new Doctor(res.getInt("doctor_id"),
                res.getString("doctor_name"),
                res.getString("spec_name"),
                res.getInt("spec_id"),
                res.getString("image_ref"));

                appt = new Appointment(patient, doctor,
                res.getInt("appt_id"),
                res.getString("start_time"),
                res.getString("end_time"),
                res.getString("appt_date"),
                res.getString("visit_type_name"),
                res.getInt("visit_type_id"),
                res.getString("status_name"),
                res.getInt("status_id"));
                
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace(); 
        } finally {
            Database.closeConnection(con);
        }
        
        return appt;
    }
    
        
    public static ArrayList getAllApptsByDoctor(int id) throws SQLException{
        Connection con = Database.getDbConnection();
        ArrayList<Appointment> appts = new ArrayList<Appointment>();
        
        Appointment appt = null;
        Patient patient = null;
        Doctor doctor = null;
        String query = "SELECT a.patient_id, patient_name, patient_age, patient_sex, "
                + "a.doctor_id, doctor_name, image_ref, d.spec_id, sp.spec_name, "
                + "a.visit_type_id, v.visit_type_name, "
                + "a.status_id, s.status_name, "
                + "appt_id, start_time, end_time, appt_date FROM appointments a "
                + "LEFT JOIN doctors d ON a.doctor_id = d.doctor_id "
                + "LEFT JOIN patients p ON a.patient_id = p.patient_id "
                + "LEFT JOIN visit_type v ON a.visit_type_id = v.visit_type_id " 
                + "LEFT JOIN status s ON a.status_id = s.status_id "
                + "LEFT JOIN specs sp ON d.spec_id = sp.spec_id "
                + "WHERE d.doctor_id = ? ORDER BY appt_date DESC, appt_id DESC;";
        
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()) {

                patient = new Patient(res.getString("patient_name"),
                res.getInt("patient_age"),
                res.getString("patient_sex"),
                res.getInt("patient_id"));

                doctor = new Doctor(res.getInt("doctor_id"),
                res.getString("doctor_name"),
                res.getString("spec_name"),
                res.getInt("spec_id"),
                res.getString("image_ref"));

                appt = new Appointment(patient, 
                        doctor,
                        res.getInt("appt_id"),
                        res.getString("start_time"),
                        res.getString("end_time"),
                        res.getString("appt_date"),
                        res.getString("visit_type_name"),
                        res.getInt("visit_type_id"),
                        res.getString("status_name"),
                        res.getInt("status_id"));
                
                appts.add(appt);
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        
        return appts;
    }
    

    public static Appointment addNewAppt(int doctorId, int patientId, String startTime, String endTime, String date, int visitTypeId, int statusId) throws SQLException{
        Connection con = Database.getDbConnection();
        Appointment appt = null;
        String query = "INSERT INTO appointments" +
                "(doctor_id, patient_id, start_time, end_time, appt_date, visit_type_id, status_id)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";
        int rowsUpdated = 0;
                
        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, doctorId);
            stmt.setInt(2, patientId);
            stmt.setString(3,startTime);
            stmt.setString(4, endTime);
            stmt.setString(5, date);
            stmt.setInt(6, visitTypeId);
            stmt.setInt(7, statusId);
            rowsUpdated = stmt.executeUpdate();
            
            if(rowsUpdated > 0) {
                ResultSet res = stmt.executeQuery("SELECT LAST_INSERT_ID() AS last_id;");
                
                if(res.next()) {
                    appt = getApptById(res.getInt("last_id"));
                } 
            }
        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
             
            if (e.getMessage().contains("foreign key constraint fails")) {
                throw new SQLException("Patient with ID #" + patientId + " does not exist.");
            }
            
            e.printStackTrace();
        } finally{
            Database.closeConnection(con);
        }
        
        return appt;
    }

    public static boolean updateApptStatus(int statusId, int apptId) throws SQLException{
        Connection con = Database.getDbConnection();
        int rowsAffected = 0;
        String query = "UPDATE appointments SET status_id = ? "
                    + "WHERE appt_id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, statusId);
            stmt.setInt(2, apptId);
             
            rowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        
        return rowsAffected > 0;
    }

    public static int deleteApptById(int apptId) throws SQLException{
        Connection con = Database.getDbConnection();
        String query = "DELETE FROM appointments WHERE appt_id = ?;";
        int numOfRowsAffected = 0;

        try {
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, apptId);

            numOfRowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            if (e.getMessage().contains("foreign key constraint fails")) {
                throw new SQLException("Appointment with ID #" + apptId + " does not exist.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return numOfRowsAffected;
    }
    
        public static boolean deleteMulApptById(ArrayList<Integer> apptIds) throws SQLException{
        Connection con = Database.getDbConnection();
        String query = "DELETE FROM appointments WHERE appt_id IN ( ";
        int numOfRowsAffected = 0;
        
        for(int i = 0; i < apptIds.size(); i++) {
            
            if(i == apptIds.size() - 1 || apptIds.size() == 1) {
                query = query + apptIds.get(i) + " );";
            } else {
                query = query  + apptIds.get(i) + ", ";
            }
        }

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            numOfRowsAffected = stmt.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            if (e.getMessage().contains("foreign key constraint fails")) {
                throw new SQLException("Failed to delete appointments. Appointments with provided IDs do not exist in the database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return numOfRowsAffected > 0;
    }
    
        public static ArrayList getAllVisitTypes() throws SQLException{
        Connection con = Database.getDbConnection();
        ArrayList<VisitType> visitTypes = new ArrayList<VisitType>();
        String query = "SELECT * FROM visit_type;";
        
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            
            while(res.next()) {
                visitTypes.add(new VisitType(res.getInt("visit_type_id"), res.getString("visit_type_name")));
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return visitTypes;
    }
        
    public static ArrayList getAllStatusTypes() throws SQLException {
        Connection con = Database.getDbConnection();
        ArrayList<Status> status = new ArrayList<Status>();
        String query = "SELECT * FROM status;";
        
        try{
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()) {
                status.add(new Status(res.getInt("status_id"), res.getString("status_name")));
            }
            
        } catch (SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establish connection with database.");
            }
            
            e.printStackTrace();
        }finally {
            Database.closeConnection(con);
        }
        
        return status;
    }
        
}


