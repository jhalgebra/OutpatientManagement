package com.horvat.bll.viewmodels.doctor;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

public class AlterDataViewModel extends BaseViewModel {
    private Patient patient;
    private Doctor doctor;

    public AlterDataViewModel(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
