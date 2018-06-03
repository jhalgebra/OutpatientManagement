package com.horvat.bll.viewmodels;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Appointment;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

import java.util.Date;

public class FillAppointmentViewModel extends BaseViewModel {
    private String delegate;
    private Date appointmentDate;
    private String details;
    private Doctor doctor;
    private Patient patient;
    private Appointment appointment;
    private Boolean secondOpinion;
    private boolean editMode;

    public FillAppointmentViewModel(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
        editMode = false;
    }

    public FillAppointmentViewModel(Doctor doctor, Patient patient, Appointment appointment) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointment = appointment;
        editMode = true;
    }

    @Override
    public boolean saveChanges(Runnable successCallback) {
        IRepository repository = RepositoryFactory.getRepository();
        boolean success;

        if (editMode)
            success = repository.updateAppointment(appointment);
        else {
            appointment = repository.insertAppointment(
                    getDoctor().getId(),
                    getPatient().getId(),
                    delegate,
                    appointmentDate,
                    details,
                    secondOpinion
            );

            success = appointment != null;
        }

        if(successCallback != null)
            successCallback.run();

        return success;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;

        if (appointment != null)
            appointment.setDelegate(delegate);
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;

        if (appointment != null)
            appointment.setDate(appointmentDate);
    }

    public void setDetails(String details) {
        this.details = details;

        if (appointment != null)
            appointment.setDetails(details);
    }

    public void setSecondOpinion(Boolean secondOpinion) {
        this.secondOpinion = secondOpinion;
    }
}
