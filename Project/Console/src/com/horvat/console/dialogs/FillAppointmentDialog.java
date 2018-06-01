package com.horvat.console.dialogs;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.base.Dialog;

import java.util.Date;

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

        String details = Helpers.enterString("Appointment details");

        Date date = Helpers.readDateInFuture("Enter date and time", true);

        viewModel.setDetails(details);
        viewModel.setAppointmentDate(date);

        viewModel.setDelegate(
                viewModel.getAppointment() != null
                        //Edit mode - doctor is editing it
                        ? viewModel.getDoctor().nameWithTitle()
                        //New appointment
                        : Helpers.enterString("Appointment delegate")
        );

        System.out.println(viewModel.saveChanges()
                ? "Data saved successfully"
                : "Data wasn't saved...");
    }
}
