package main.java.models;

public class Specialization {

    private int specId;
    private String specName;
   
    public Specialization(int id, String name) {
        this.specId = id;
        this.specName = name;
    }

    public int getSpecId() { return specId; }

    public void setSpecId(int specId) { this.specId = specId; }

    public String getSpecName() { return specName; }

    public void setSpecName(String specName) { this.specName = specName; }
    
    @Override
    public String toString() { return this.specName; }
}
