package com.horvat.console.dialogs.report;

import com.horvat.bll.viewmodels.report.ReportViewModel;
import com.horvat.console.dialogs.base.Dialog;

public class ReportDialog extends Dialog<ReportViewModel> {
    public ReportDialog(String title, char underlineChar, ReportViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }
}
