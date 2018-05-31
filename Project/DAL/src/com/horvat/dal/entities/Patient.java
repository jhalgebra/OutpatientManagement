package com.horvat.dal.entities;

import com.lib.dal.entities.IDatabaseObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Patient implements IDatabaseObject<Patient> {
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
    private ImportantMedicalComplaints importantMedicalComplaints;

    public Patient() { }

    public Patient(Integer id, Date registrationDate, Boolean basicRegistration, List<Bill> bills, List<Appointment> appointments, List<Test> tests, List<PrescribedMedicine> prescribedMedicine, BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints importantMedicalComplaints) {
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

    public ImportantMedicalComplaints getImportantMedicalComplaints() {
        return importantMedicalComplaints;
    }

    public void setImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints) {
        this.importantMedicalComplaints = importantMedicalComplaints;
    }

    @Override
    public Function<Object[], Patient> getConverter(Object... objects) {
        return data -> new Patient(
                (Integer)data[0],
                (Date)data[1],
                (Boolean)data[2],
                null,
                null,
                null,
                null,
                new BasicDetails(
                        (String)data[3],
                        (String)data[4],
                        (String)data[5],
                        (Date)data[6]
                ),
                new ContactDetails(
                        (String)data[7],
                        (String)data[8],
                        new Contact(
                                (String)data[9],
                                (String)data[10],
                                (String)data[11],
                                (String)data[12],
                                (String)data[13],
                                (String)data[14]
                        )
                ),
                new ContactOfNextOfKin(
                        (String)data[15],
                        (String)data[16],
                        new Contact(
                                (String)data[17],
                                (String)data[18],
                                (String)data[19],
                                (String)data[20],
                                (String)data[21],
                                (String)data[22]
                        )
                ),
                new PersonalDetails(
                        (Boolean)data[23],
                        (Integer)data[24],
                        (Double)data[25],
                        (Double)data[26],
                        (String)data[27]
                ),
                new ProfessionDetails(
                        (String)data[28],
                        (BigDecimal)data[29]
                ),
                new Lifestyle(
                        (Boolean)data[30],
                        (Boolean)data[31],
                        (Boolean)data[32],
                        (Boolean)data[33],
                        (String)data[34],
                        (Double)data[35],
                        (Double)data[36],
                        (Double)data[37],
                        (Boolean)data[38],
                        (String)data[39]
                ),
                new BasicComplaints(
                        (String)data[40],
                        (String)data[41],
                        (String)data[42]
                ),
                new ImportantMedicalComplaints(
                        (Boolean)data[43],
                        (Boolean)data[44],
                        (String)data[45],
                        (String)data[46],
                        (String)data[47],
                        (String)data[48],
                        (String)data[49],
                        (String)data[50],
                        (String)data[51],
                        (String)data[52],
                        (String)data[53]
                )
        );
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", registrationDate=" + registrationDate +
                ", basicRegistration=" + basicRegistration +
                ", bills=" + bills +
                ", appointments=" + appointments +
                ", tests=" + tests +
                ", prescribedMedicine=" + prescribedMedicine +
                ", basicDetails=" + basicDetails +
                ", contactDetails=" + contactDetails +
                ", contactOfNextOfKin=" + contactOfNextOfKin +
                ", personalDetails=" + personalDetails +
                ", professionDetails=" + professionDetails +
                ", lifestyle=" + lifestyle +
                ", basicComplaints=" + basicComplaints +
                ", importantMedicalComplaints=" + importantMedicalComplaints +
                '}';
    }
}
