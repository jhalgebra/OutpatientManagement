package com.horvat.console.dialogs;

import com.horvat.bll.viewmodels.doctor.DoctorMenuViewModel;
import com.horvat.bll.viewmodels.MainMenuViewModel;
import com.horvat.bll.viewmodels.receptionist.ReceptionistMenuViewModel;
import com.horvat.bll.viewmodels.report.ReportViewModel;
import com.horvat.console.app.Utils;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.console.dialogs.doctor.DoctorMenuDialog;
import com.horvat.console.dialogs.receptionist.ReceptionistMenuDialog;
import com.horvat.console.dialogs.report.ReportDialog;
import com.horvat.dl.entities.Doctor;

import java.util.ArrayList;
import java.util.List;

public class MainMenuDialog extends Dialog<MainMenuViewModel> {
    public MainMenuDialog(String title, char underlineChar, MainMenuViewModel viewModel) {
        super(title, underlineChar, viewModel);

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption("Login as a doctor", () -> {
                List<Doctor> doctors = viewModel.getDoctors();

                if (doctors.size() == 0) {
                    System.out.println("Can't login as a doctor, there aren't any doctors in the database...");
                    dialogNavigator.reprintCurrentDialog();
                    return;
                }

                System.out.println(Utils.getUnderlined("Choose a doctor", '-'));

                dialogNavigator.goToNewDialog(
                        new DoctorMenuDialog(
                                "Doctor Menu",
                                '=',
                                new DoctorMenuViewModel(Utils.chooseOption(viewModel.getDoctors()))
                        )
                );
            }));

            add(new DialogOption("Login as a receptionist", () -> dialogNavigator.goToNewDialog(
                    new ReceptionistMenuDialog(
                            "Receptionist Menu",
                            '=',
                            new ReceptionistMenuViewModel()
                    )
            )));

            add(new DialogOption("View Reports", () -> dialogNavigator.goToNewDialog(
                    new ReportDialog(
                            "Reports",
                            '=',
                            new ReportViewModel()
                    )
            )));

            add(new DialogOption("Exit", () -> {
                Utils.scanner.close();
                System.exit(0);
            }));
        }};
    }
}
