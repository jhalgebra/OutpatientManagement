package com.horvat.bll.viewmodels.report;

import com.horvat.bll.viewmodels.base.BaseViewModel;

public class WeeklyOrMonthlyReportViewModel extends BaseViewModel {
    private boolean monthly;

    public WeeklyOrMonthlyReportViewModel(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isMonthly() {
        return monthly;
    }
}
