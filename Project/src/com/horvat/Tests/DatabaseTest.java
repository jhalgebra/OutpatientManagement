package com.horvat.Tests;

import com.horvat.dal.data.IRepository;
import com.horvat.dal.data.RepositoryFactory;
import com.horvat.dal.entities.*;
import com.lib.dal.entities.IDatabaseObject;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.*;

public class DatabaseTest {
    private static IRepository repo;

    static {
        try {
            repo = RepositoryFactory.getRepository();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        if(repo == null)
            return;

        testGetters(1, true);
        List<IDatabaseObject> addedObjects = testInserts();
        testGetters(2, false);
        testDeletes(addedObjects);
        testGetters(2, false);
    }

    private static void testDeletes(List<IDatabaseObject> addedObjects) {
        Boolean patientRemoved = repo.removePatient(((Patient)addedObjects.get(0)).getId());
        Boolean testRemoved = repo.removeTest(((Test)addedObjects.get(1)).getId());
        Boolean medicineRemoved = repo.removePrescribedMedicine(((PrescribedMedicine)addedObjects.get(2)).getId());
        Boolean billRemoved = repo.removeBill(((Bill)addedObjects.get(3)).getId());
        Boolean appointmentRemoved = repo.removeAppointment(((Appointment)addedObjects.get(4)).getId());

        System.out.println("Patient removed: " + (patientRemoved));
        System.out.println("Test removed: " + (testRemoved));
        System.out.println("Medicine removed: " + (medicineRemoved));
        System.out.println("Bill removed: " + (billRemoved));
        System.out.println("Appointment removed: " + (appointmentRemoved));
    }

    private static List<IDatabaseObject> testInserts(){
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

        System.out.println();

        List<IDatabaseObject> addedObjects = new ArrayList<>();

        addedObjects.add(newPatient);
        addedObjects.add(newTest);
        addedObjects.add(medicine);
        addedObjects.add(newBill);
        addedObjects.add(appointment);

        return addedObjects;
    }

    private static void testGetters(Integer patientID, Boolean printEnums){
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
