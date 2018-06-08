package com.horvat.dl.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MedicalComplaints implements IDisplayable {
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

    public MedicalComplaints(Boolean diabetic, Boolean hypertensive, String cardiacCondition, String respiratoryCondition, String digestiveCondition, String orthopedicCondition, String muscularCondition, String neurologicalCondition, String knownAllergies, String knownAdverseReactionToSpecificDrugs, String majorSurgeries) {
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
        return "MedicalComplaints{" +
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

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Diabetic", diabetic);
                put("Hypertensive", hypertensive);
                put("Cardiac condition", cardiacCondition);
                put("Respiratory condition", respiratoryCondition);
                put("Digestive condition", digestiveCondition);
                put("Orthopedic condition", orthopedicCondition);
                put("Muscular condition", muscularCondition);
                put("Neurological condition", neurologicalCondition);
                put("Known allergies", knownAllergies);
                put("Known adverse reaction to specific drugs", knownAdverseReactionToSpecificDrugs);
                put("Major surgeries", majorSurgeries);
            }});
        }};
    }

    @Override
    public Map<String, List<? extends IDisplayable>> getInnerData() {
        return null;
    }
}
