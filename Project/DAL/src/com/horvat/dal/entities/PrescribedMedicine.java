package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.util.Date;
import java.util.function.Function;

public class PrescribedMedicine implements IDatabaseObject<PrescribedMedicine> {
    private Integer id;
    private Integer doctorID;
    private String name;
    private Double quantity;
    private Date dateIssued;
    private String doctorName;

    public PrescribedMedicine() { }

    public PrescribedMedicine(Integer id, Integer doctorID, String name, Double quantity, Date dateIssued, String doctorName) {
        this.id = id;
        this.doctorID = doctorID;
        this.name = name;
        this.quantity = quantity;
        this.dateIssued = dateIssued;
        this.doctorName = doctorName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
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

    @Override
    public Function<Object[], PrescribedMedicine> getConverter(Object... objects) {
        return data -> new PrescribedMedicine(
                (Integer)data[0],
                (Integer)data[1],
                (String)data[2],
                (Double)data[3],
                (Date)data[4],
                (String)data[5]
        );
    }

    @Override
    public String toString() {
        return "PrescribedMedicine{" +
                "id=" + id +
                ", doctorID=" + doctorID +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", dateIssued=" + dateIssued +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
