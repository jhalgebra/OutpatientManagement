package com.horvat.console.dialogs.report;

import com.horvat.bll.viewmodels.report.WeeklyOrMonthlyReportViewModel;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.dl.entities.Doctor;

import java.util.ArrayList;
import java.util.function.BiConsumer;

public class WeeklyOrMonthlyReportDialog extends Dialog<WeeklyOrMonthlyReportViewModel> {
    public WeeklyOrMonthlyReportDialog(String title, char underlineChar, WeeklyOrMonthlyReportViewModel viewModel) {
        super(title, underlineChar, viewModel);

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption(
                    "View average number of patients treated per doctor",
                    () -> {
                        viewModel.getPatientReport().getNumPatientsForDoctors().forEach(
                                (Doctor doctor, Double avg)
                                        -> System.out.println("Average patients for " + doctor.nameWithTitle() + ": " + avg.intValue())
                        );

                        dialogNavigator.reprintCurrentDialogAfterInput(10);
                    }
            ));

            add(new DialogOption(
                    "View number of patients that are new or looking for second opinion",
                    () -> {
                        System.out.println("Number of patients that are new or looking for second opinion: " +
                                viewModel.getPatientReport().getNumNewOrSecondOpinionPatients());

                        dialogNavigator.reprintCurrentDialogAfterInput(10);
                    })
            );
        }};
    }
}
