package com.horvat.dl.entities;

import java.text.MessageFormat;
import java.util.*;

public class Test implements IDisplayable {
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
    public String toString() {
        return MessageFormat.format(
                "Test {0} issued by {1} on {2}:{3}Details: {4}",
                name,
                doctorName,
                date,
                System.lineSeparator(),
                details
        );
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Name", name);
                put("Date", date);
                put("Details", details);
                put("Doctor's name", "Dr. " + doctorName);
            }});
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
