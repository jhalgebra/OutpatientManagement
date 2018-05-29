package com.horvat.dal.entities;

import java.util.Date;

public class BasicDetails {
    private String name;
    private String oib;
    private String sex;
    private Date dateOfBirth;

    public BasicDetails(String name, String oib, String sex, Date dateOfBirth) {
        this.name = name;
        this.oib = oib;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getSex() {
        return sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
