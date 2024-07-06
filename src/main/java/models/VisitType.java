
package main.java.models;

public class VisitType {
    private int visitTypeId;
    private String visitTypeName;
    
    public VisitType () { }
    
    public VisitType (int id, String name) {
        this.visitTypeId = id;
        this.visitTypeName = name;
    }

    public int getVisitTypeId() { return visitTypeId; }

    public void setVisitTypeId(int visitTypeId) { this.visitTypeId = visitTypeId; }

    public String getVisitTypeName() { return visitTypeName; }

    public void setVisitTypeName(String visitTypeName) { this.visitTypeName = visitTypeName;  }
    
    @Override
    public String toString() { return this.visitTypeName; }
}
