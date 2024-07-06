package main.java.models;

public class Doctor {
    private int doctorId;
    private String doctorName;
    private String specializationName;
    private int specId;
    private String imgRef;
    private boolean isAuthenticated;

    public Doctor () { }

    public Doctor(int id, String name, String specializationName, int specId, String ref) {
        this.doctorId = id;
        this.doctorName = name;
        this.specializationName = specializationName;
        this.specId = specId;
        this.imgRef = ref;
    }

    public void setName(String name) { this.doctorName = name; }

    public void setDoctorId(int id) { this.doctorId = id; }

    public void setSpecializationName(String specializationName) { this.specializationName = specializationName; }

    public void setSpecId(int id) { this.specId = id; }

    public void setIsAuthenticated(boolean b) { this.isAuthenticated = b; }
    
    public String getName() { return doctorName; }

    public boolean getAuthenticationStatus() { return isAuthenticated; }

    public int getDoctorId() { return doctorId; }
    
    public String getSpecializationName() { return specializationName; }
    
    public int getSpecializationId() { return specId; }
    
    public String getImgRef() { return imgRef;} 

    public void setImgRef(String imgRef) { this.imgRef = imgRef; }
    
    
    /* NOT recommended to override toString() method but ehh ¯\_(ツ)_/¯*/
    @Override
    public String toString() { return "Dr. " + doctorName ; }


}