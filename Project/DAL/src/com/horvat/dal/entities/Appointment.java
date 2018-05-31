package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.util.Date;
import java.util.function.Function;

public class Appointment implements IDatabaseObject<Appointment> {
    private Integer id;
    private Integer doctorID;
    private String delegate;
    private Date date;
    private String details;
    private String doctorName;

    public Appointment() { }

    public Appointment(Integer id, Integer doctorID, String delegate, Date date, String details, String doctorName) {
        this.id = id;
        this.doctorID = doctorID;
        this.delegate = delegate;
        this.date = date;
        this.details = details;
        this.doctorName = doctorName;
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

    @Override
    public Function<Object[], Appointment> getConverter(Object... objects) {
        return data -> new Appointment(
                (Integer)data[0],
                (Integer)data[1],
                (String)data[2],
                (Date)data[3],
                (String)data[4],
                (String)data[5]
        );
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorID=" + doctorID +
                ", delegate='" + delegate + '\'' +
                ", date=" + date +
                ", details='" + details + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
