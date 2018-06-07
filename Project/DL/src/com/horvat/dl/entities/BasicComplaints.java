package com.horvat.dl.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicComplaints implements IDisplayable {
    private String statementOfComplaint;
    private String historyOfPreviousTreatment;
    private String physicianOrHospitalTreated;

    public BasicComplaints(String statementOfComplaint, String historyOfPreviousTreatment, String physicianOrHospitalTreated) {
        this.statementOfComplaint = statementOfComplaint;
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
        this.physicianOrHospitalTreated = physicianOrHospitalTreated;
    }

    public String getStatementOfComplaint() {
        return statementOfComplaint;
    }

    public void setStatementOfComplaint(String statementOfComplaint) {
        this.statementOfComplaint = statementOfComplaint;
    }

    public String getHistoryOfPreviousTreatment() {
        return historyOfPreviousTreatment;
    }

    public void setHistoryOfPreviousTreatment(String historyOfPreviousTreatment) {
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
    }

    public String getPhysicianOrHospitalTreated() {
        return physicianOrHospitalTreated;
    }

    public void setPhysicianOrHospitalTreated(String physicianOrHospitalTreated) {
        this.physicianOrHospitalTreated = physicianOrHospitalTreated;
    }

    @Override
    public String toString() {
        return "BasicComplaints{" +
                "statementOfComplaint='" + statementOfComplaint + '\'' +
                ", historyOfPreviousTreatment='" + historyOfPreviousTreatment + '\'' +
                ", physicianOrHospitalTreated='" + physicianOrHospitalTreated + '\'' +
                '}';
    }

    @Override
    public Map<String, Map<String, Object>> getDisplayDataGroups() {
        return new HashMap<String, Map<String, Object>>() {{
            put(NON_GROUPED_NAME, new HashMap<String, Object>() {{
                put("Statement of complaint", statementOfComplaint);
                put("History of previous treatment", historyOfPreviousTreatment);
                put("Physician or hospital that treated the patient", physicianOrHospitalTreated);
            }});
        }};
    }
}
