package com.horvat.dal.entities;

public class PersonalDetails {
    private boolean married;
    private int numberOfDependents;
    private double height;
    private double weight;
    private String bloodTypeRH;

    public PersonalDetails(boolean married, int numberOfDependents, double height, double weight, String bloodTypeRH) {
        this.married = married;
        this.numberOfDependents = numberOfDependents;
        this.height = height;
        this.weight = weight;
        this.bloodTypeRH = bloodTypeRH;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public int getNumberOfDependents() {
        return numberOfDependents;
    }

    public void setNumberOfDependents(int numberOfDependents) {
        this.numberOfDependents = numberOfDependents;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodTypeRH() {
        return bloodTypeRH;
    }

    public void setBloodTypeRH(String bloodTypeRH) {
        this.bloodTypeRH = bloodTypeRH;
    }
}
