package com.horvat.dal.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.horvat.dal.entities.*;

public interface IRepository {

    //===Patients===
    int insertPatientWithBasicDetails(
        String name,
        int sexID,
        Date dateOfBirth,
        String statementOfComplaint,
        String telephoneWork,
        String telephoneHome,
        String nameOfNextOfKin
    );

    int insertPatientWithFullDetails(Patient patient);
    Patient insertPatientWithFullDetails(
        BasicDetails basicDetails,
        ContactDetails contactDetails,
        ContactOfNextOfKin contactOfNextOfKin,
        PersonalDetails personalDetails,
        ProfessionDetails professionDetails,
        Lifestyle lifestyle,
        BasicComplaints basicComplaints,
        ImportantMedicalComplaints medicalComplaints
    );

    void removePatient(int patientID);
    List<Patient> getPatients();

    //===Bills===
    int insertBill(
        int paymentTypeID,
        int patientID,
        BigDecimal amount
    );

    void removeBill(int billID);

    List<Bill> getBills(int patientID);

    //===Appointments===
    int insertAppointment(
        int doctorID,
        int patientID,
        String delegate,
        Date dateAppointed,
        String details
    );

    void removeAppointment(int appointmentID);

    List<Appointment> getAppointments(int patientID);

    //===Tests===
    int insertTest(
        int patientID,
        int doctorID,
        String name,
        String details,
        Date testDateTime
    );

    void removeTest(int testID);

    List<Test> getTests(int patientID);

    //===PrescribedMedicine===
    int insertPrescribedMedicine(
            double quantity,
            int medicineID,
            int patientID,
            int doctorID
    );

    void removePrescribedMedicine(int prescribedMedicineID);

    List<PrescribedMedicine> getPrescribedMedicine(int patientID);

    //Other objects' getters
    List<Doctor> getDoctors();
    //"Enums"
    Map<Integer, String> getPaymentTypes();
    Map<Integer, String> getPredominantEatingOptions();
    Map<Integer, String> getSexes();
    Map<Integer, String> getMedicines();

}
