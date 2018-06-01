package com.horvat.console.dialogs.receptionist;

import com.horvat.bll.viewmodels.FillAppointmentViewModel;
import com.horvat.bll.viewmodels.receptionist.InsertPatientViewModel;
import com.horvat.bll.viewmodels.receptionist.IssueBillViewModel;
import com.horvat.bll.viewmodels.receptionist.ReceptionistMenuViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.FillAppointmentDialog;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class ReceptionistMenuDialog extends Dialog<ReceptionistMenuViewModel> {
    private List<Patient> patients;
    private List<Doctor> doctors;

    public ReceptionistMenuDialog(String title, char underlineChar, ReceptionistMenuViewModel viewModel) {
        super(title, underlineChar, viewModel);

        patients = viewModel.getPatients();
        doctors = viewModel.getDoctors();

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption(
                    "Insert New Patient",
                    item -> {
                        boolean basic = Helpers.chooseOption("Basic Registration", "Full Registration") == 1;

                        dialogNavigator.goToNewDialog(new InsertPatientDialog(
                                "Insert new patient (" + (basic ? "Basic)" : "Full)"),
                                '=',
                                new InsertPatientViewModel(basic))
                        );
                    })
            );

            add(new DialogOption(
                    "Make an Appointment",
                    item -> {
                        Patient patient = Helpers.chooseOption(patients);
                        Doctor doctor = Helpers.chooseOption(doctors);

                        dialogNavigator.goToNewDialog(new FillAppointmentDialog(
                                "Make an Appointment",
                                '=',
                                new FillAppointmentViewModel(doctor, patient)));
                    })
            );

            add(new DialogOption(
                    "Issue Bill",
                    item -> {
                        Patient patient = Helpers.chooseOption(patients);

                        dialogNavigator.goToNewDialog(new IssueBillDialog(
                                "Issue Bill to " + patient.getBasicDetails().getName(),
                                '=',
                                new IssueBillViewModel(patient))
                        );
                    })
            );
        }};
    }
}
