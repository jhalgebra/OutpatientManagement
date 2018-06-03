package com.horvat.dl.entities;

import java.text.MessageFormat;
import java.util.Date;

public class Appointment{
    private Integer id;
    private Integer doctorID;
    private String delegate;
    private Date date;
    private String details;
    private String doctorName;
    private Boolean secondOpinion;

    public Appointment() { }

    public Appointment(Integer id, Integer doctorID, String delegate, Date date, String details, String doctorName, Boolean secondOpinion) {
        this.id = id;
        this.doctorID = doctorID;
        this.delegate = delegate;
        this.date = date;
        this.details = details;
        this.doctorName = doctorName;
        this.secondOpinion = secondOpinion;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDoctorID() {
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

    public Boolean getSecondOpinion() {
        return secondOpinion;
    }

    public void setSecondOpinion(Boolean secondOpinion) {
        this.secondOpinion = secondOpinion;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "{0} scheduled an appointment to see dr. {1} on {2}{3}Details: {4}",
                delegate,
                doctorName,
                date,
                System.lineSeparator(),
                details
        );
    }
}
