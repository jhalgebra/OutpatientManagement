package com.horvat.dal.entities;

import java.util.Date;

public class Patient {
    private int id;
    private Date registrationDate;
    private boolean basicRegistration;

    private BasicDetails basicDetails;
    private ContactDetails contactDetails;
    private ContactOfNextOfKin contactOfNextOfKin;
    private PersonalDetails personalDetails;
    private ProfessionDetails professionDetails;
    private Lifestyle lifestyle;
    private BasicComplaints basicComplaints;
    private ImportantMedicalComplaints importantMedicalComplaints;

    public Patient(int id, Date registrationDate, boolean basicRegistration, BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints importantMedicalComplaints) {

        this.id = id;
        this.registrationDate = registrationDate;
        this.basicRegistration = basicRegistration;
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

    public BasicDetails getBasicDetails() {
        return basicDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public ContactOfNextOfKin getContactOfNextOfKin() {
        return contactOfNextOfKin;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public ProfessionDetails getProfessionDetails() {
        return professionDetails;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public BasicComplaints getBasicComplaints() {
        return basicComplaints;
    }

    public ImportantMedicalComplaints getImportantMedicalComplaints() {
        return importantMedicalComplaints;
    }
}
