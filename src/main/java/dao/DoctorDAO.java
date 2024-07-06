package main.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.database.Database;
import main.java.models.Doctor;
import main.java.models.Schedule;
import main.java.models.Specialization;


public class DoctorDAO {
    public static ArrayList getDoctorBySpecialization(int id) throws SQLException{
        Connection con = null;
        ArrayList<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctors d " +
                        "LEFT JOIN specs s ON s.spec_id  = d.spec_id  " +
                        "WHERE d.spec_id = ?;";

        try{
            con = Database.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Doctor doctor = new Doctor(
                        res.getInt("doctor_id"),
                        res.getString("doctor_name"),
                        res.getString("spec_name"),
                        res.getInt("spec_id"),
                        res.getString("image_ref")
                );

                doctors.add(doctor);
            }

        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establis connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return doctors;
    }

    public static ArrayList getDoctorSchedules(int id) throws SQLException{
        Connection con = null;
        ArrayList<Schedule> schedules = new ArrayList<>();
        String query = "SELECT doctor_schedules.doctor_schedule_id, " +
                        "doctor_id, " +
                        "doctor_schedule_items.schedule_item_id, " +
                        "doctor_schedule_items.start_time, " +
                        "doctor_schedule_items.end_time, " +
                        "doctor_schedule_items.day " +
                        "FROM doctor_schedules LEFT JOIN doctor_schedule_items " +
                        "ON doctor_schedule_items.doctor_schedule_id = doctor_schedules.doctor_schedule_id " +
                        "WHERE doctor_id = ?;";
        
        try{
            con = Database.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();

            while(res.next()) {
                Schedule sched = new Schedule(
                        res.getString("start_time"),
                        res.getString("end_time"),
                        res.getInt("day")
                );

                schedules.add(sched);
            }
        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establis connection with database.");
            }
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return schedules;
    }

    public static Doctor getDoctorById(int id) throws SQLException {
        Connection con = Database.getDbConnection();
        Doctor doctor = new Doctor();
        String query = "SELECT * FROM doctors d "
                + "LEFT JOIN specs s ON s.spec_id = d.spec_id "
                + "WHERE d.doctor_id = ?;";

        try{
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            res.next();

            doctor.setDoctorId(res.getInt("doctor_id"));
            doctor.setName(res.getString("doctor_name"));
            doctor.setSpecializationName(res.getString("spec_name"));
            doctor.setSpecId(res.getInt("spec_id"));
            doctor.setImgRef(res.getString("image_ref"));
        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establis connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }

        return doctor;
    }
    
    public static ArrayList getAllDoctorSpecializations() throws SQLException {
        Connection con = Database.getDbConnection();
        ArrayList<Specialization> specs = new ArrayList<Specialization>();
        String query = "SELECT * FROM specs;";

        try{
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            
            while (res.next()) {
                specs.add(new Specialization(res.getInt("spec_id"), res.getString("spec_name")));
            }
        } catch(SQLException e) {
            if (e.getMessage().contains("Communications link failure")) {
                throw new SQLException("Failed to establis connection with database.");
            }
            
            e.printStackTrace();
        } finally {
            Database.closeConnection(con);
        }
        return specs;
    }

}
