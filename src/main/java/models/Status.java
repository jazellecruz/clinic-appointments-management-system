/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.models;

public class Status {
    private int statusId;
    private String statusName;
    
    public Status() {}
    
    public Status(int id, String name) {
        this.statusId = id;
        this.statusName = name;
    }

    public int getStatusId() { return statusId; }
    
    public void setStatusId(int statusId) { this.statusId = statusId; }

    public String getStatusName() { return statusName; }

    public void setStatusName(String statusName) { this.statusName = statusName; }
    
    @Override
    public String toString() { return statusName; }
    
}
