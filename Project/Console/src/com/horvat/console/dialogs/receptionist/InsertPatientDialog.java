package com.horvat.console.dialogs.receptionist;

import com.horvat.bll.viewmodels.receptionist.InsertPatientViewModel;
import com.horvat.console.app.Helpers;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.dl.entities.*;

import java.util.Date;

public class InsertPatientDialog extends Dialog<InsertPatientViewModel> {
    public InsertPatientDialog(String title, char underlineChar, InsertPatientViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        /*
        *
        basicDetails.getName(),
        basicDetails.getSex(),
        basicDetails.getDateOfBirth(),
        basicComplaints.getStatementOfComplaint(),
        contactDetails.getContact().getTelephoneWork(),
        contactDetails.getContact().getTelephoneHome(),
        contactOfNextOfKin.getName()
        *
        */

        String name = Helpers.enterString("name");
        String sex = Helpers.chooseOption(viewModel.getSexes()).getValue();
        Date dateOfBirth = Helpers.readDate(item -> true, "Enter date of birth", false);
        String statementOfComplaint = Helpers.enterString("statement of complaint");
        String telephoneWork = Helpers.enterString("work telephone");
        String telephoneHome = Helpers.enterString("home telephone");
        String nameOfNextOfKin = Helpers.enterString("Name of next of kin");

        if(viewModel.isBasic()){
            viewModel.setBasicDetails(new BasicDetails(name, null, sex, dateOfBirth));
            viewModel.setBasicComplaints(new BasicComplaints(statementOfComplaint, null, null));
            viewModel.setContactDetails(new ContactDetails(null, null, new Contact(telephoneHome, telephoneWork, null, null, null, null)));
            viewModel.setContactOfNextOfKin(new ContactOfNextOfKin(nameOfNextOfKin, null, null));
        }
        else{
            //TODO: compelete for full registration
        }

        System.out.println(viewModel.saveChanges()
                ? "Data saved successfully"
                : "Data wasn't saved...");
    }
}
