package com.horvat.dal.entities;

import java.util.Date;

public class PrescribedMedicine {
    private int id;
    private int doctorID;
    private String name;
    private double quantity;
    private Date dateIssued;
    private String doctorName;

    public PrescribedMedicine(int id, int doctorID, String name, double quantity, Date dateIssued, String doctorName) {
        this.id = id;
        this.doctorID = doctorID;
        this.name = name;
        this.quantity = quantity;
        this.dateIssued = dateIssued;
        this.doctorName = doctorName;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
