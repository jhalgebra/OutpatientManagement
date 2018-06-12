package com.horvat.console.dialogs.doctor;

import com.horvat.bll.viewmodels.doctor.AlterDataViewModel;
import com.horvat.bll.viewmodels.doctor.DoctorMenuViewModel;
import com.horvat.bll.viewmodels.doctor.OrderTestViewModel;
import com.horvat.bll.viewmodels.doctor.PrescribeMedicineViewModel;
import com.horvat.console.app.Utils;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.dl.entities.Patient;

import java.util.ArrayList;
import java.util.List;

public class DoctorMenuDialog extends Dialog<DoctorMenuViewModel> {
    private List<Patient> patients;

    public DoctorMenuDialog(String title, char underlineChar, DoctorMenuViewModel viewModel) {
        super(title, underlineChar, viewModel);

        patients = viewModel.getPatients();

        if (patients.size() == 0) {
            System.out.println("Doctor currently has no patients");
            dialogNavigator.goToPreviousDialog();
        }

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption("View Patients' Data", () -> {
                for (Patient patient : patients)
                    System.out.println(patient.getFullInfo());

                dialogNavigator.reprintCurrentDialogAfterInput(10);
            }));

            add(new DialogOption("Order Test for Patient", () -> {
                Patient patient = choosePatient();

                dialogNavigator.goToNewDialog(new OrderTestDialog(
                        "Order Test for " + patient.getBasicDetails().getName(),
                        '=',
                        new OrderTestViewModel(patient, viewModel.getDoctor())
                ));
            }));

            add(new DialogOption("Prescribe Medicine to patient", () ->{
                Patient patient = choosePatient();

                dialogNavigator.goToNewDialog(new PrescribeMedicineDialog(
                        "Prescribe Medicine to " + patient.getBasicDetails().getName(),
                        '=',
                        new PrescribeMedicineViewModel(patient, viewModel.getDoctor())
                ));
            }));

            add(new DialogOption("Alter Future Appointments", () ->{
                Patient patient = choosePatient();

                dialogNavigator.goToNewDialog(new AlterDataDialog(
                        "Alter " + patient.getBasicDetails().getName() + "'s appointments",
                        '=',
                        new AlterDataViewModel(patient, viewModel.getDoctor())
                ));
            }));
        }};
    }

    private Patient choosePatient() {
        return Utils.chooseOption(
                patients
                , patient -> patient.getBasicDetails().getName()
        );
    }
}
