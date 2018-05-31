package com.horvat.dal.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.horvat.dal.entities.*;
import javafx.util.Pair;

public interface IRepository {

    //region Patient

    Patient insertPatientWithBasicDetails(
        String name,
        Integer sexID,
        Date dateOfBirth,
        String statementOfComplaint,
        String telephoneWork,
        String telephoneHome,
        String nameOfNextOfKin
    );

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

    Boolean removePatient(Integer patientID);
    List<Patient> getPatients();

    //endregion

    //region Bill

    Bill insertBill(
        String paymentType,
        Integer patientID,
        BigDecimal amount
    );

    Boolean removeBill(Integer billID);

    List<Bill> getBills(Integer patientID);

    //endregion

    //region Appointment

    Appointment insertAppointment(
        Integer doctorID,
        Integer patientID,
        String delegate,
        Date dateAppointed,
        String details
    );

    Boolean removeAppointment(Integer appointmentID);

    List<Appointment> getAppointments(Integer patientID);

    //endregion

    //region Test

    Test insertTest(
        Integer patientID,
        Integer doctorID,
        String name,
        String details,
        Date testDateTime
    );

    Boolean removeTest(Integer testID);

    List<Test> getTests(Integer patientID);

    //endregion

    //region PrescribedMedicine

    PrescribedMedicine insertPrescribedMedicine(
            Double quantity,
            String medicineName,
            Integer patientID,
            Integer doctorID
    );

    Boolean removePrescribedMedicine(Integer prescribedMedicineID);

    List<PrescribedMedicine> getPrescribedMedicine(Integer patientID);

    //endregion

    List<Doctor> getDoctors();

    //region "Enums"

    List<Pair<Integer, String>> getPaymentTypes();
    List<Pair<Integer, String>> getPredominantEatingOptions();
    List<Pair<Integer, String>> getSexes();
    List<Pair<Integer, String>> getMedicines();

    //endregion

}
