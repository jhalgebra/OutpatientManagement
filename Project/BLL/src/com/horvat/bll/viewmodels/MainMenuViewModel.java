package com.horvat.bll.viewmodels;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Doctor;

import java.util.List;

public class MainMenuViewModel extends BaseViewModel {
    public List<Doctor> getDoctors(){
        return RepositoryFactory.getRepository().getDoctors();
    }
}
