package com.horvat.dal.entities;

public class BasicComplaints {
    private String statementOfComplaint;
    private String historyOfPreviousTreatment;
    private String PhysicianOrHospitalTreated;

    public BasicComplaints(String statementOfComplaint, String historyOfPreviousTreatment, String physicianOrHospitalTreated) {
        this.statementOfComplaint = statementOfComplaint;
        this.historyOfPreviousTreatment = historyOfPreviousTreatment;
        PhysicianOrHospitalTreated = physicianOrHospitalTreated;
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
        return PhysicianOrHospitalTreated;
    }

    public void setPhysicianOrHospitalTreated(String physicianOrHospitalTreated) {
        PhysicianOrHospitalTreated = physicianOrHospitalTreated;
    }
}
