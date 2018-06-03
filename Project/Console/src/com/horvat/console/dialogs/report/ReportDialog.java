package com.horvat.console.dialogs.report;

import com.horvat.bll.viewmodels.report.DailyReportViewModel;
import com.horvat.bll.viewmodels.report.ReportViewModel;
import com.horvat.bll.viewmodels.report.WeeklyOrMonthlyReportViewModel;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.console.dialogs.base.DialogOption;

import java.util.ArrayList;

public class ReportDialog extends Dialog<ReportViewModel> {
    public ReportDialog(String title, char underlineChar, ReportViewModel viewModel) {
        super(title, underlineChar, viewModel);

        options = new ArrayList<DialogOption>() {{
            add(new DialogOption("Daily", () -> dialogNavigator.goToNewDialog(
                    new DailyReportDialog(
                            "Daily Report",
                            '=',
                            new DailyReportViewModel()
                    )
            )));

            add(new DialogOption("Weekly", () -> dialogNavigator.goToNewDialog(
                    new WeeklyOrMonthlyReportDialog(
                            "Weekly Report",
                            '=',
                            new WeeklyOrMonthlyReportViewModel(false)
                    )
            )));

            add(new DialogOption("Monthly", () -> dialogNavigator.goToNewDialog(
                    new WeeklyOrMonthlyReportDialog(
                            "Monthly Report",
                            '=',
                            new WeeklyOrMonthlyReportViewModel(true)
                    )
            )));
        }};
    }
}
