package com.horvat.Tests;

import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Appointment;
import com.horvat.dl.entities.Bill;
import com.horvat.dl.entities.Patient;
import com.horvat.dl.entities.Test;
import com.horvat.dl.entities.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

public class DatabaseTest {
    private static final IRepository repo = RepositoryFactory.getRepository();

    public static void run() {
        if(repo == null)
            return;

        testGetters(1, true);
        List<Object> addedObjects = testInserts();
        testGetters(2, false);
        testDeletes(addedObjects);
        testGetters(2, false);
    }

    private static void testDeletes(List<Object> addedObjects) {
        boolean patientRemoved = repo.removePatient(((Patient)addedObjects.get(0)).getId());
        boolean testRemoved = repo.removeTest(((Test)addedObjects.get(1)).getId());
        boolean medicineRemoved = repo.removePrescribedMedicine(((PrescribedMedicine)addedObjects.get(2)).getId());
        boolean billRemoved = repo.removeBill(((Bill)addedObjects.get(3)).getId());
        boolean appointmentRemoved = repo.removeAppointment(((Appointment)addedObjects.get(4)).getId());
        boolean fullPatientRemoved = repo.removePatient(((Patient)addedObjects.get(5)).getId());

        System.out.println("Patient removed: " + (patientRemoved));
        System.out.println("Test removed: " + (testRemoved));
        System.out.println("Medicine removed: " + (medicineRemoved));
        System.out.println("Bill removed: " + (billRemoved));
        System.out.println("Appointment removed: " + (appointmentRemoved));
        System.out.println("Full patient removed: " + (fullPatientRemoved));
    }

    private static List<Object> testInserts(){
        Patient newPatient = repo.insertPatientWithBasicDetails("Luka", 1, Date.from(ZonedDateTime.now().minusMonths(300).toInstant()), "Complaining", "3841123", "3841444", "Mirko");
        System.out.println("Added new patient: " + newPatient);

        Test newTest = repo.insertTest(2, 2, "Chill test", "The patient wasn't chillin'", Date.from(ZonedDateTime.now().minusMonths(50).toInstant()));
        System.out.println("Added new test: " + newTest);

        PrescribedMedicine medicine = repo.insertPrescribedMedicine(1.0, "Lupocet", 2, 4);
        System.out.println("Prescribed new medicine: " + medicine);

        Bill newBill = repo.insertBill("Credit Card", 2, BigDecimal.valueOf(234));
        System.out.println("Printed new bill: " + newBill);

        Appointment appointment = repo.insertAppointment(4, 2, "Nurse", Date.from(ZonedDateTime.now().plusMonths(130).toInstant()), "None");
        System.out.println("Added new appointment: " + appointment);

        Patient newFullPatient = repo.insertPatientWithFullDetails(new BasicDetails("Jerko", "1239123", "Male", Date.from(ZonedDateTime.now().minusYears(20).toInstant())), new ContactDetails("Maksimirska 13", "Braće Domany 6", new Contact("3841234", "3840345", "0912584293", "454", "3840293", "neki@email.com")), new ContactOfNextOfKin("Miroslav", "Neka adresa", new Contact("3841845", "3840213", "0992340231", "923", "3840222", "kontakt@firma.com")), new PersonalDetails(true, 2, 184.3, 88.2, "AB+"), new ProfessionDetails("Lawyer", BigDecimal.valueOf(88888)), new Lifestyle(true, true, true, false, "None", 3.0, 0.0, 2.0, true, "Home Food"), new BasicComplaints("Stuff hurts man", "None", "Some Hospital"), new MedicalComplaints(true, true, "Good", "Bad", "Good", "OK", "Good", "Bad", "None", "None", "None"));
        System.out.println("Added new full patient: " + newFullPatient);

        System.out.println();

        List<Object> addedObjects = new ArrayList<>();

        addedObjects.add(newPatient);
        addedObjects.add(newTest);
        addedObjects.add(medicine);
        addedObjects.add(newBill);
        addedObjects.add(appointment);
        addedObjects.add((newFullPatient));

        return addedObjects;
    }

    private static void testGetters(int patientID, boolean printEnums){
        if(printEnums) {
            print(repo.getMedicines());
            print(repo.getPaymentTypes());
            print(repo.getPredominantEatingOptions());
            print(repo.getSexes());
        }

        print(repo.getPatients());
        print(repo.getDoctors());

        print(repo.getAppointments(patientID));
        print(repo.getBills(patientID));
        print(repo.getPrescribedMedicine(patientID));
        print(repo.getTests(patientID));
    }

    private static <T> void print(List<T> listToPrint){
        if(listToPrint == null)
            return;

        for(T item : listToPrint){
            System.out.println(item);
        }

        System.out.println();
    }
}
