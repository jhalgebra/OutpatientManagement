package com.horvat.dl.entities;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

public class Patient {
    private Integer id;
    private Date registrationDate;
    private Boolean basicRegistration;
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
    private MedicalComplaints medicalComplaints;

    public Patient() {
    }

    public Patient(Integer id, Date registrationDate, Boolean basicRegistration, List<Bill> bills, List<Appointment> appointments, List<Test> tests, List<PrescribedMedicine> prescribedMedicine, BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, MedicalComplaints medicalComplaints) {
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
        this.medicalComplaints = medicalComplaints;
    }

    public Integer getId() {
        return id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Boolean isBasicRegistration() {
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

    public MedicalComplaints getMedicalComplaints() {
        return medicalComplaints;
    }

    public void setMedicalComplaints(MedicalComplaints medicalComplaints) {
        this.medicalComplaints = medicalComplaints;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "{0} ({1}, born {2}): registered on {3} (Basic: {4}){5}" +
                        "Contact: home - {6}, work - {7}, name of next of kin - {8}{9}" +
                        "Statement of complaint: {10}",
                basicDetails.getName(),
                basicDetails.getSex(),
                basicDetails.getDateOfBirth(),
                registrationDate,
                basicRegistration,
                System.lineSeparator(),
                contactDetails.getContact().getTelephoneHome(),
                contactDetails.getContact().getTelephoneWork(),
                contactOfNextOfKin.getName(),
                System.lineSeparator(),
                basicComplaints.getStatementOfComplaint()
        );
    }

    public String getFullInfo() {
        String line = System.lineSeparator() + "===============================================";

        StringBuilder info = new StringBuilder(line)
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(toString());

        appendCollection(info, "Appointments:", appointments);
        appendCollection(info, "Tests:", tests);
        appendCollection(info, "Prescribed Medicine:", prescribedMedicine);
        appendCollection(info, "Bills:", bills);

        info
                .append(System.lineSeparator())
                .append(line);

        return info.toString();
    }

    private <T> void appendCollection(StringBuilder builder, String label, List<T> collection) {
        builder.append(System.lineSeparator()).append(System.lineSeparator());

        builder.append(label);

        if (collection.size() == 0) {
            builder.append(" empty").append(System.lineSeparator());
            return;
        }

        for (T item : collection) {
            builder.append(System.lineSeparator()).append(System.lineSeparator());
            builder.append(item.toString());
        }
    }
}
