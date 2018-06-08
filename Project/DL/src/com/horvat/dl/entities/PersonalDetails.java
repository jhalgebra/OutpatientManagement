package com.horvat.dl.entities;

import java.util.*;

public class PersonalDetails implements IDisplayable {
    private Boolean married;
    private Integer numberOfDependents;
    private Double height;
    private Double weight;
    private String bloodTypeRH;

    public PersonalDetails(Boolean married, Integer numberOfDependents, Double height, Double weight, String bloodTypeRH) {
        this.married = married;
        this.numberOfDependents = numberOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodTypeRH = bloodTypeRH;
    }

    public Boolean isMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Integer getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(Integer numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBloodTypeRH() {
        return bloodTypeRH;
    }

    public void setBloodTypeRH(String bloodTypeRH) {
        this.bloodTypeRH = bloodTypeRH;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "married=" + married +
                ", numberOfDependents=" + numberOfDependents +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodTypeRH='" + bloodTypeRH + '\'' +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Married", married);
                put("Number of dependents", numberOfDependents);
                put("Height", height);
                put("Weight", weight);
                put("Blood type and RH factor", bloodTypeRH);
            }});
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
