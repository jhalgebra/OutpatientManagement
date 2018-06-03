package com.horvat.console.dialogs;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.doctor.DoctorMenuDialog;
import com.horvat.console.dialogs.receptionist.ReceptionistMenuDialog;
import com.horvat.dl.entities.Appointment;

import java.util.Date;
import java.util.List;

public class FillAppointmentDialog extends Dialog<FillAppointmentViewModel> {
    public FillAppointmentDialog(String title, char underlineChar, FillAppointmentViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        if (viewModel.isEditMode() &&
                !Helpers.confirm("You are about to override appointment " + viewModel.getAppointment())
                ) {
            dialogNavigator.goToPreviousDialog();
            return;
        }

        Boolean secondOpinion = Helpers.readBoolean("Second opinion");
        String details = Helpers.enterString("Appointment details");

        Date date = Helpers.readDateInFuture("Enter date and time", true);

        viewModel.setSecondOpinion(secondOpinion);
        viewModel.setDetails(details);
        viewModel.setAppointmentDate(date);

        viewModel.setDelegate(
                viewModel.getAppointment() != null
                        //Edit mode - doctor is editing it
                        ? viewModel.getDoctor().nameWithTitle()
                        //New appointment
                        : Helpers.enterString("Appointment delegate")
        );

        dialogNavigator.goBackOnSuccess(
                this,
                () -> {
                    if (viewModel.isEditMode()) {
                        Appointment addedAppointment = viewModel.getAppointment();
                        List<Appointment> patientsAppointments = viewModel.getPatient().getAppointments();

                        for (int i = 0; i < patientsAppointments.size(); i++) {
                            if (patientsAppointments.get(i).getId().equals(addedAppointment.getId())) {
                                patientsAppointments.set(i, addedAppointment);
                                break;
                            }
                        }
                    } else
                        viewModel.getPatient().getAppointments().add(viewModel.getAppointment());
                },
                viewModel.isEditMode()
                        ? DoctorMenuDialog.class
                        : ReceptionistMenuDialog.class
        );
    }
}
