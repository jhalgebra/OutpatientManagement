package com.horvat.dal.entities;

import java.util.Date;

public class Appointment {
    private int id;
    private int doctorID;
    private String delegate;
    private Date date;
    private String details;
    private String doctorName;

    public Appointment(int id, int doctorID, String delegate, Date date, String details, String doctorName) {
        this.id = id;
        this.doctorID = doctorID;
        this.delegate = delegate;
        this.date = date;
        this.details = details;
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
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

    public String getDoctorName() {
        return doctorName;
    }
}
