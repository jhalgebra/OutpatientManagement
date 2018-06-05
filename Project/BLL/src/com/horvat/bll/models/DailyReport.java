package com.horvat.bll.models;

import com.horvat.bll.helpers.DateWithin;
import com.horvat.bll.helpers.Utils;
import com.horvat.dl.entities.Bill;
import com.horvat.dl.entities.Patient;
import com.horvat.dl.entities.PrescribedMedicine;
import com.horvat.dl.entities.Test;
import com.horvat.dl.helpers.ToStringUtils;
import javafx.util.Pair;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class DailyReport {
    private List<Bill> bills;
    private List<Test> tests;
    private List<PrescribedMedicine> medicines;

    private Patient patient;

    public DailyReport(Patient patient) {
        this.patient = patient;

        bills = new ArrayList<>();
        for(Bill bill : patient.getBills())
            if(Utils.dateWithin(DateWithin.TODAY, bill.getDateIssued()))
                bills.add(bill);

        tests = new ArrayList<>();
        for(Test test : patient.getTests())
            if(Utils.dateWithin(DateWithin.TODAY, test.getDate()))
                tests.add(test);

        medicines = new ArrayList<>();
        for(PrescribedMedicine medicine : patient.getPrescribedMedicine())
            if(Utils.dateWithin(DateWithin.TODAY, medicine.getDateIssued()))
                medicines.add(medicine);
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<Test> getTests() {
        return tests;
    }

    public List<PrescribedMedicine> getMedicines() {
        return medicines;
    }

    @Override
    public String toString() {
        return patient.toString() + ToStringUtils.construct('=',
                new Pair<>("Bills:", new ArrayList<>(bills)),
                new Pair<>("Tests:", new ArrayList<>(tests)),
                new Pair<>("Prescribed Medicine:", new ArrayList<>(medicines))
        );
    }
}
