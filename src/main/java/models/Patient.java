package main.java.models;

public class Patient {
    private String patientName;
    private int patientAge;
    private String patientSex;
    private int patientId;

    public Patient() { }

    public Patient(String name, int age, String sex, int patientId) {
        this.patientName = name;
        this.patientAge = age;
        this.patientSex = sex;
        this.patientId = patientId;
    }

    public void setName(String newName) { this.patientName = newName; }

    public void setAge(int newAge) { this.patientAge = newAge; }
    
    public void setSex(String newSex) { this.patientSex = newSex; }
    
    public void setPatientId(int newPatientId) { this.patientId = newPatientId; }

    public String getName() { return patientName; }

    public int getAge() { return patientAge; }

    public String getSex() { return patientSex; }

    public int getPatientId() { return patientId; }
}




