package com.example.admin.profilemanager.models;

/**
 * Created by Admin on 03-04-2016.
 */
public class TimeModel {

    int id;
    String fromTime, toTime, modeOfPhone;

    public TimeModel() {
        this.id = 0;
        this.fromTime = "";
        this.toTime = "";
        this.modeOfPhone = "";

    }

    public TimeModel(int id, String fromTime, String toTime, String modeOfPhone) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.modeOfPhone = modeOfPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getModeOfPhone() {
        return modeOfPhone;
    }

    public void setModeOfPhone(String modeOfPhone) {
        this.modeOfPhone = modeOfPhone;
    }
}
