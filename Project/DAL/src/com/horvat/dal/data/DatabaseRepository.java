package com.horvat.dal.data;

import com.horvat.dal.entities.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DatabaseRepository implements IRepository {
    @Override
    public int insertPatientWithBasicDetails(String name, int sexID, Date dateOfBirth, String statementOfComplaint, String telephoneWork, String telephoneHome, String nameOfNextOfKin) {
        return 0;
    }

    @Override
    public int insertPatientWithFullDetails(Patient patient) {
        return 0;
    }

    @Override
    public Patient insertPatientWithFullDetails(BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints medicalComplaints) {
        return null;
    }

    @Override
    public void removePatient(int patientID) {

    }

    @Override
    public List<Patient> getPatients() {
        return null;
    }

    @Override
    public int insertBill(int paymentTypeID, int patientID, BigDecimal amount) {
        return 0;
    }

    @Override
    public void removeBill(int billID) {

    }

    @Override
    public List<Bill> getBills(int patientID) {
        return null;
    }

    @Override
    public int insertAppointment(int doctorID, int patientID, String delegate, Date dateAppointed, String details) {
        return 0;
    }

    @Override
    public void removeAppointment(int appointmentID) {

    }

    @Override
    public List<Appointment> getAppointments(int patientID) {
        return null;
    }

    @Override
    public int insertTest(int patientID, int doctorID, String name, String details, Date testDateTime) {
        return 0;
    }

    @Override
    public void removeTest(int testID) {

    }

    @Override
    public List<Test> getTests(int patientID) {
        return null;
    }

    @Override
    public int insertPrescribedMedicine(double quantity, int medicineID, int patientID, int doctorID) {
        return 0;
    }

    @Override
    public void removePrescribedMedicine(int prescribedMedicineID) {

    }

    @Override
    public List<PrescribedMedicine> getPrescribedMedicine(int patientID) {
        return null;
    }

    @Override
    public List<Doctor> getDoctors() {
        return null;
    }

    @Override
    public Map<Integer, String> getPaymentTypes() {
        return null;
    }

    @Override
    public Map<Integer, String> getPredominantEatingOptions() {
        return null;
    }

    @Override
    public Map<Integer, String> getSexes() {
        return null;
    }

    @Override
    public Map<Integer, String> getMedicines() {
        return null;
    }
}
