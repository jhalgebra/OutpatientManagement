package com.horvat.bll.viewmodels.receptionist;

import com.horvat.bll.viewmodels.base.BaseViewModel;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.*;
import javafx.util.Pair;

import java.util.List;

public class InsertPatientViewModel extends BaseViewModel {
    private boolean basic;
    private BasicDetails basicDetails;
    private ContactDetails contactDetails;
    private ContactOfNextOfKin contactOfNextOfKin;
    private PersonalDetails personalDetails;
    private ProfessionDetails professionDetails;
    private Lifestyle lifestyle;
    private BasicComplaints basicComplaints;
    private MedicalComplaints medicalComplaints;
    private Patient patient;

    public InsertPatientViewModel(boolean basic) {
        this.basic = basic;
    }

    public boolean isBasic() {
        return basic;
    }

    @Override
    public boolean saveChanges(Runnable successCallback) {
        IRepository repository = RepositoryFactory.getRepository();

        if (basic)
            patient = repository.insertPatientWithBasicDetails(
                    basicDetails.getName(),
                    basicDetails.getSex(),
                    basicDetails.getDateOfBirth(),
                    basicComplaints.getStatementOfComplaint(),
                    contactDetails.getContact().getTelephoneWork(),
                    contactDetails.getContact().getTelephoneHome(),
                    contactOfNextOfKin.getName()
            );
        else
            patient = repository.insertPatientWithFullDetails(
                    basicDetails,
                    contactDetails,
                    contactOfNextOfKin,
                    personalDetails,
                    professionDetails,
                    lifestyle,
                    basicComplaints,
                    medicalComplaints
            );

        boolean changesSaved = patient != null;

        if(successCallback != null && changesSaved)
            successCallback.run();

        return changesSaved;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setBasicDetails(BasicDetails basicDetails) {
        this.basicDetails = basicDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void setContactOfNextOfKin(ContactOfNextOfKin contactOfNextOfKin) {
        this.contactOfNextOfKin = contactOfNextOfKin;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public void setProfessionDetails(ProfessionDetails professionDetails) {
        this.professionDetails = professionDetails;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public void setBasicComplaints(BasicComplaints basicComplaints) {
        this.basicComplaints = basicComplaints;
    }

    public void setMedicalComplaints(MedicalComplaints medicalComplaints) {
        this.medicalComplaints = medicalComplaints;
    }

    public List<Pair<Integer, String>> getSexes() {
        return RepositoryFactory.getRepository().getSexes();
    }

    public List<Pair<Integer, String>> getPredominantEatingOptions() {
        return RepositoryFactory.getRepository().getPredominantEatingOptions();
    }
}
