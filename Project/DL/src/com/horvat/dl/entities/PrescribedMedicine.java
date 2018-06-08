package com.horvat.dl.entities;

import java.text.MessageFormat;
import java.util.*;

public class PrescribedMedicine implements IDisplayable {
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
    public String toString() {
        return MessageFormat.format(
                "{0} issued by dr. {1} on {2}, {3} pcs",
                name,
                doctorName,
                dateIssued,
                quantity
        );
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Name", name);
                put("Quantity", quantity);
                put("Date issued", dateIssued);
                put("Doctor's name", "Dr. " + doctorName);
            }});
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
