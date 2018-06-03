package com.horvat.bll.viewmodels.doctor;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;
import com.horvat.dl.entities.PrescribedMedicine;
import javafx.util.Pair;

import java.util.List;

public class PrescribeMedicineViewModel extends BaseViewModel {
    private Patient patient;
    private Doctor doctor;
    private PrescribedMedicine medicine;
    private Double quantity;
    private String medicineName;

    public PrescribeMedicineViewModel(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public boolean saveChanges(Runnable successCallback){
        IRepository repository = RepositoryFactory.getRepository();

        medicine = repository.insertPrescribedMedicine(
                quantity,
                medicineName,
                patient.getId(),
                doctor.getId()
        );

        if(successCallback != null)
            successCallback.run();

        return medicine != null;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Patient getPatient() {
        return patient;
    }

    public PrescribedMedicine getMedicine() {
        return medicine;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<Pair<Integer, String>> getMedicines(){
        return RepositoryFactory.getRepository().getMedicines();
    }
}
