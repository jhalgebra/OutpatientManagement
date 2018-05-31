package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.util.Date;
import java.util.function.Function;

public class Doctor implements IDatabaseObject<Doctor> {
    private Integer id;
    private BasicDetails basicDetails;

    public Doctor() { }

    public Doctor(Integer id, BasicDetails basicDetails) {
        this.id = id;
        this.basicDetails = basicDetails;
    }

    public Integer getId() {
        return id;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    @Override
    public Function<Object[], Doctor> getConverter(Object... objects) {
        return data -> new Doctor(
                (Integer)data[0],
                new BasicDetails(
                        (String)data[1],
                        (String)data[2],
                        (String)data[3],
                        (Date)data[4]
                )
        );
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", basicDetails=" + basicDetails +
                '}';
    }
}
