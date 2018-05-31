package com.horvat.dl.entities;

import java.text.MessageFormat;

public class Doctor {
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
    public String toString() {
        return MessageFormat.format(
                "Dr. {0}: {1}, born {2}; OIB: {3}",
                basicDetails.getName(),
                basicDetails.getSex(),
                basicDetails.getDateOfBirth(),
                basicDetails.getOib()
        );
    }
}
