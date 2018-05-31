package com.horvat.dal.entities;

public class ImportantMedicalComplaints {
    private Boolean diabetic;
    private Boolean hypertensive;
    private String cardiacCondition;
    private String respiratoryCondition;
    private String digestiveCondition;
    private String orthopedicCondition;
    private String muscularCondition;
    private String neurologicalCondition;
    private String knownAllergies;
    private String knownAdverseReactionToSpecificDrugs;
    private String majorSurgeries;

    public ImportantMedicalComplaints(Boolean diabetic, Boolean hypertensive, String cardiacCondition, String respiratoryCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownAdverseReactionToSpecificDrugs, String majorSurgeries) {
        this.diabetic = diabetic;
        this.hypertensive = hypertensive;
        this.cardiacCondition = cardiacCondition;
        this.respiratoryCondition = respiratoryCondition;
        this.digestiveCondition = digestiveCondition;
        this.orthopedicCondition = orthopedicCondition;
        this.muscularCondition = muscularCondition;
        this.neurologicalCondition = neurologicalCondition;
        this.knownAllergies = knownAllergies;
        this.knownAdverseReactionToSpecificDrugs = knownAdverseReactionToSpecificDrugs;
        this.majorSurgeries = majorSurgeries;
    }

    public Boolean isDiabetic() {
        return diabetic;
    }

    public void setDiabetic(Boolean diabetic) {
        this.diabetic = diabetic;
    }

    public Boolean isHypertensive() {
        return hypertensive;
    }

    public void setHypertensive(Boolean hypertensive) {
        this.hypertensive = hypertensive;
    }

    public String getCardiacCondition() {
        return cardiacCondition;
    }

    public void setCardiacCondition(String cardiacCondition) {
        this.cardiacCondition = cardiacCondition;
    }

    public String getRespiratoryCondition() {
        return respiratoryCondition;
    }

    public void setRespiratoryCondition(String respiratoryCondition) {
        this.respiratoryCondition = respiratoryCondition;
    }

    public String getDigestiveCondition() {
        return digestiveCondition;
    }

    public void setDigestiveCondition(String digestiveCondition) {
        this.digestiveCondition = digestiveCondition;
    }

    public String getOrthopedicCondition() {
        return orthopedicCondition;
    }

    public void setOrthopedicCondition(String orthopedicCondition) {
        this.orthopedicCondition = orthopedicCondition;
    }

    public String getMuscularCondition() {
        return muscularCondition;
    }

    public void setMuscularCondition(String muscularCondition) {
        this.muscularCondition = muscularCondition;
    }

    public String getNeurologicalCondition() {
        return neurologicalCondition;
    }

    public void setNeurologicalCondition(String neurologicalCondition) {
        this.neurologicalCondition = neurologicalCondition;
    }

    public String getKnownAllergies() {
        return knownAllergies;
    }

    public void setKnownAllergies(String knownAllergies) {
        this.knownAllergies = knownAllergies;
    }

    public String getKnownAdverseReactionToSpecificDrugs() {
        return knownAdverseReactionToSpecificDrugs;
    }

    public void setKnownAdverseReactionToSpecificDrugs(String knownAdverseReactionToSpecificDrugs) {
        this.knownAdverseReactionToSpecificDrugs = knownAdverseReactionToSpecificDrugs;
    }

    public String getMajorSurgeries() {
        return majorSurgeries;
    }

    public void setMajorSurgeries(String majorSurgeries) {
        this.majorSurgeries = majorSurgeries;
    }

    @Override
    public String toString() {
        return "ImportantMedicalComplaints{" +
                "diabetic=" + diabetic +
                ", hypertensive=" + hypertensive +
                ", cardiacCondition='" + cardiacCondition + '\'' +
                ", respiratoryCondition='" + respiratoryCondition + '\'' +
                ", digestiveCondition='" + digestiveCondition + '\'' +
                ", orthopedicCondition='" + orthopedicCondition + '\'' +
                ", muscularCondition='" + muscularCondition + '\'' +
                ", neurologicalCondition='" + neurologicalCondition + '\'' +
                ", knownAllergies='" + knownAllergies + '\'' +
                ", knownAdverseReactionToSpecificDrugs='" + knownAdverseReactionToSpecificDrugs + '\'' +
                ", majorSurgeries='" + majorSurgeries + '\'' +
                '}';
    }
}
