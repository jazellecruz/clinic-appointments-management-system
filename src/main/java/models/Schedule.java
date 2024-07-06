package main.java.models;

import main.java.utils.Utils;

public class Schedule {

    private String startTime;
    private String endTime;
    private int day;

    public Schedule(String startTime, String endTime, int day) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
    }

    public void setStartTime(String startTime) { this.startTime = startTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }

    public void setDay(int day) { this.day = day; }

    public int getDay() { return day; }

    public String getEndTime() { return endTime; }

    public String getStartTime() { return startTime; }

    @Override
    public String toString() {
        return Utils.convertTimeFormat(this.startTime) + " - "
                + Utils.convertTimeFormat(this.endTime) + " "
                + Utils.convertIntToDay(this.day);
    }
}
