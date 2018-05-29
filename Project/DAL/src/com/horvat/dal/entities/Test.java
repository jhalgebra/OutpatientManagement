package com.horvat.dal.entities;

import java.util.Date;

public class Test {
    private int id;
    private int doctorID;
    private String name;
    private String doctorName;
    private Date date;
    private String details;

    public Test(int id, int doctorID, String name, String doctorName, Date date, String details) {
        this.id = id;
        this.doctorID = doctorID;
        this.name = name;
        this.doctorName = doctorName;
        this.date = date;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
