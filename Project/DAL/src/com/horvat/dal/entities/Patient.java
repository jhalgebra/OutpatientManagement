package com.horvat.dal.entities;

import java.util.Date;
import java.util.List;

public class Patient {
    private int id;
    private Date registrationDate;
    private boolean basicRegistration;
    private List<Bill> bills;
    private List<Appointment> appointments;
    private List<Test> tests;
    private List<PrescribedMedicine> prescribedMedicine;

    private BasicDetails basicDetails;
    private ContactDetails contactDetails;
    private ContactOfNextOfKin contactOfNextOfKin;
    private PersonalDetails personalDetails;
    private ProfessionDetails professionDetails;
    private Lifestyle lifestyle;
    private BasicComplaints basicComplaints;
    private ImportantMedicalComplaints importantMedicalComplaints;

    public Patient(int id, Date registrationDate, boolean basicRegistration, List<Bill> bills, List<Appointment> appointments, List<Test> tests, List<PrescribedMedicine> prescribedMedicine, BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints importantMedicalComplaints) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.basicRegistration = basicRegistration;
        this.bills = bills;
        this.appointments = appointments;
        this.tests = tests;
        this.prescribedMedicine = prescribedMedicine;
        this.basicDetails = basicDetails;
        this.contactDetails = contactDetails;
        this.contactOfNextOfKin = contactOfNextOfKin;
        this.personalDetails = personalDetails;
        this.professionDetails = professionDetails;
        this.lifestyle = lifestyle;
        this.basicComplaints = basicComplaints;
        this.importantMedicalComplaints = importantMedicalComplaints;
    }

    public int getId() {
        return id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public boolean isBasicRegistration() {
        return basicRegistration;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<PrescribedMedicine> getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(List<PrescribedMedicine> prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public ContactOfNextOfKin getContactOfNextOfKin() {
        return contactOfNextOfKin;
    }

    public void setContactOfNextOfKin(ContactOfNextOfKin contactOfNextOfKin) {
        this.contactOfNextOfKin = contactOfNextOfKin;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public ProfessionDetails getProfessionDetails() {
        return professionDetails;
    }

    public void setProfessionDetails(ProfessionDetails professionDetails) {
        this.professionDetails = professionDetails;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public BasicComplaints getBasicComplaints() {
        return basicComplaints;
    }

    public void setBasicComplaints(BasicComplaints basicComplaints) {
        this.basicComplaints = basicComplaints;
    }

    public ImportantMedicalComplaints getImportantMedicalComplaints() {
        return importantMedicalComplaints;
    }

    public void setImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints) {
        this.importantMedicalComplaints = importantMedicalComplaints;
    }
}
