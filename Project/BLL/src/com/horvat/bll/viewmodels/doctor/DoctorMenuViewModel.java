package com.horvat.bll.viewmodels.doctor;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

import java.util.List;

public class DoctorMenuViewModel extends BaseViewModel {
    private Doctor doctor;

    public DoctorMenuViewModel(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<Patient> getPatients() {
        return RepositoryFactory.getRepository().getPatientsForDoctor(doctor.getId());
    }
}
