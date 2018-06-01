package com.horvat.bll.viewmodels.receptionist;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

import java.util.List;

public class ReceptionistMenuViewModel extends BaseViewModel {
    public List<Doctor> getDoctors(){
        return RepositoryFactory.getRepository().getDoctors();
    }

    public List<Patient> getPatients(){
        return RepositoryFactory.getRepository().getPatients();
    }
}
