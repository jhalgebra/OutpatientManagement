package com.horvat.dl.entities;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Doctor implements IDisplayable {
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
                "{0}: {1}, born {2}; OIB: {3}",
                nameWithTitle(),
                basicDetails.getSex(),
                basicDetails.getDateOfBirth(),
                basicDetails.getOib()
        );
    }

    public String nameWithTitle(){
        return "Dr. " + getBasicDetails().getName();
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, basicDetails.getDisplayDataGroups().get(NON_GROUPED_NAME));
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
