package com.horvat.console.dialogs.doctor;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.bll.viewmodels.doctor.AlterDataViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.FillAppointmentDialog;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.dl.entities.Appointment;
import com.horvat.dl.entities.Patient;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

public class AlterDataDialog extends Dialog<AlterDataViewModel> {
    public AlterDataDialog(String title, char underlineChar, AlterDataViewModel viewModel) {
        super(title, underlineChar, viewModel);

        Patient patient = viewModel.getPatient();

        options = new ArrayList<>();

        Date now = Helpers.getCurrentDate();

        int counter = 1;
        for (Appointment appointment : patient.getAppointments()) {
            Date appointmentDate = appointment.getDate();

            if (appointmentDate.after(now)) {
                options.add(new DialogOption(
                        MessageFormat.format(
                                "Update appointment {0} ({1}): {2}",
                                counter++,
                                appointmentDate,
                                appointment.getDetails()
                        ),
                        () -> {
                            dialogNavigator.goToNewDialog(new FillAppointmentDialog(
                                    "Alter appointment for " + patient.getBasicDetails().getName(),
                                    '=',
                                    new FillAppointmentViewModel(viewModel.getDoctor(), patient, appointment)
                            ));
                        }
                ));
            }
        }
    }
}
