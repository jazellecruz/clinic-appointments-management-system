package main.java.models;

public class Appointment {

    private int apptId;
    private int doctorId;
    private int patientId;
    private String startTime;
    private String endTime;
    private String apptDate;
    private String status;
    private int statusId ;
    private int visitTypeId;
    private String visitTypeName;
    
    /* Establish a HAS-A-RELATIONSHIP with Patient and Doctor classes/objects. */
    private Patient patient;
    private Doctor doctor;

    public Appointment() { }

    public Appointment(Patient patient, Doctor doctor, int apptId, String startTime, String endTime, String date, String visitTypeName, int visitTypeId, String status, int statusId) {
        this.patient = patient;
        this.doctor = doctor;
        this.apptId = apptId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.apptDate = date;
        this.status = status;
        this.statusId = statusId;
        this.visitTypeId = visitTypeId;
        this.visitTypeName = visitTypeName;
    }

    public Appointment(int apptId, int doctorId, int patientId, String startTime, String endTime, String apptDate, String status, int statusId) {
        this.apptId = apptId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.apptDate = apptDate;
        this.status = status;
        this.statusId = statusId;
        this.visitTypeId = visitTypeId;
        this.visitTypeName = visitTypeName;
    }

    public void setApptId(int i) { this.apptId = i; }

    public void setDoctorId(int i) { this.doctorId = i; }

    public void setPatientId(int i) { this.patientId = i; }

    public void setStartTime(String s) { this.startTime = s; }

    public void setEndTime(String s) { this.endTime = s; }

    public void setDate(String s) { this.apptDate = s; }

    public void setStatus(String s) { this.status = s; }

    public void setStatusId(int i) { this.statusId = i; };

    public int getApptId() { return apptId; }

    public int getDoctorId() { return doctorId; }

    public int getPatientId() { return patientId; }

    public String getStartTime() { return startTime; }

    public String getEndTime() { return endTime; }

    public String getDate() { return apptDate; }

    public String getStatus() { return status; }

    public int getStatusId() { return statusId; }

    public int getVisitTypeId() { return visitTypeId; }

    public void setVisitTypeId(int visitTypeId) { this.visitTypeId = visitTypeId; }

    public String getVisitTypeName() { return visitTypeName; }

    public void setVisitTypeName(String visitTypeName) { this.visitTypeName = visitTypeName; }
    
    public Patient getPatient() { return patient; }

    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }

    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
}
