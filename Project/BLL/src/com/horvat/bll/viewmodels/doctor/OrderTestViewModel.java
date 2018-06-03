package com.horvat.bll.viewmodels.doctor;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;
import com.horvat.dl.entities.Test;

import java.util.Date;

public class OrderTestViewModel extends BaseViewModel {
    private Patient patient;
    private Doctor doctor;
    private Test test;

    private String name;
    private String details;
    private Date testDate;

    public OrderTestViewModel(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public boolean saveChanges(Runnable successCallback) {
        IRepository repository = RepositoryFactory.getRepository();

        test = repository.insertTest(
                patient.getId(),
                doctor.getId(),
                name,
                details,
                testDate
        );

        if(successCallback != null)
            successCallback.run();

        return test != null;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Test getTest() {
        return test;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
