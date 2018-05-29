package com.horvat.dal.entities;

public class Doctor {
    private int id;
    private BasicDetails basicDetails;

    public Doctor(int id, BasicDetails basicDetails) {
        this.id = id;
        this.basicDetails = basicDetails;
    }

    public int getId() {
        return id;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }
}
