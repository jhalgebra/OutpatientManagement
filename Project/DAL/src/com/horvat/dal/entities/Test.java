package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.util.Date;
import java.util.function.Function;

public class Test implements IDatabaseObject<Test> {
    private Integer id;
    private Integer doctorID;
    private String name;
    private String doctorName;
    private Date date;
    private String details;

    public Test() { }

    public Test(Integer id, Integer doctorID, String name, String doctorName, Date date, String details) {
        this.id = id;
        this.doctorID = doctorID;
        this.name = name;
        this.doctorName = doctorName;
        this.date = date;
        this.details = details;
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

    @Override
    public Function<Object[], Test> getConverter(Object... objects) {
        return data -> new Test(
                (Integer)data[0],
                (Integer)data[1],
                (String)data[2],
                (String)data[3],
                (Date)data[4],
                (String)data[5]
        );
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", doctorID=" + doctorID +
                ", name='" + name + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                ", details='" + details + '\'' +
                '}';
    }
}
