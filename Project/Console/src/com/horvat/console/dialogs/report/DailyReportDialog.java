package com.horvat.console.dialogs.report;

import com.horvat.bll.viewmodels.report.DailyReportViewModel;
import com.horvat.console.dialogs.base.Dialog;

public class DailyReportDialog extends Dialog<DailyReportViewModel> {
    public DailyReportDialog(String title, char underlineChar, DailyReportViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }
}
