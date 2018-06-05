package com.horvat.console.dialogs.report;

import com.horvat.bll.models.PatientReport;
import com.horvat.bll.viewmodels.report.DailyReportViewModel;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;
import com.horvat.dl.entities.Doctor;

import java.util.ArrayList;

public class DailyReportDialog extends Dialog<DailyReportViewModel> {
    public DailyReportDialog(String title, char underlineChar, DailyReportViewModel viewModel) {
        super(title, underlineChar, viewModel);

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption("View bills, tests and prescribed medicine for patients",
                    () -> {
                        viewModel.getReports().forEach(System.out::println);

                        dialogNavigator.reprintCurrentDialogAfterInput(10);
                    }
            ));

            add(new DialogOption("View patient report",
                    () -> {
                        PatientReport report = viewModel.getPatientReport();

                        System.out.println("Number of patients that are new or looking for second opinion: " +
                                report.getNumNewOrSecondOpinionPatients()
                        );

                        System.out.println("Number of patients treated per doctor:");

                        report.getNumPatientsForDoctors().forEach(
                                (Doctor doc, Double count) -> System.out.println(doc.nameWithTitle() + ": " + count.intValue())
                        );

                        dialogNavigator.reprintCurrentDialogAfterInput(10);
                    }
            ));
        }};
    }
}
