package com.horvat.bll.viewmodels.report;

import com.horvat.bll.helpers.DateWithin;
import com.horvat.bll.models.DailyReport;
import com.horvat.bll.models.PatientReport;
import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DailyReportViewModel extends BaseViewModel {
    private IRepository repository = RepositoryFactory.getRepository();

    public List<DailyReport> getReports(){
        return repository.getPatients().stream().map(DailyReport::new).collect(Collectors.toList());
    }

    public PatientReport getPatientReport(){
        return new PatientReport(DateWithin.TODAY);
    }
}
