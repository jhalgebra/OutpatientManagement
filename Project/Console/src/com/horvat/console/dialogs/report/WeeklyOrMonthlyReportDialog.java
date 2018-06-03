package com.horvat.console.dialogs.report;

import com.horvat.bll.viewmodels.report.WeeklyOrMonthlyReportViewModel;
import com.horvat.console.dialogs.base.Dialog;

public class WeeklyOrMonthlyReportDialog extends Dialog<WeeklyOrMonthlyReportViewModel> {
    public WeeklyOrMonthlyReportDialog(String title, char underlineChar, WeeklyOrMonthlyReportViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }
}
