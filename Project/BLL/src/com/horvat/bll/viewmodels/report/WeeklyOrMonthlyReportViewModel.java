package com.horvat.bll.viewmodels.report;

import com.horvat.bll.helpers.DateWithin;
import com.horvat.bll.models.PatientReport;
import com.horvat.bll.viewmodels.base.BaseViewModel;

public class WeeklyOrMonthlyReportViewModel extends BaseViewModel {
    private boolean monthly;

    public WeeklyOrMonthlyReportViewModel(boolean monthly) {
        this.monthly = monthly;
    }

    public boolean isMonthly() {
        return monthly;
    }

    public PatientReport getPatientReport(){
        return new PatientReport(monthly ? DateWithin.THIS_MONTH : DateWithin.THIS_WEEK);
    }
}
