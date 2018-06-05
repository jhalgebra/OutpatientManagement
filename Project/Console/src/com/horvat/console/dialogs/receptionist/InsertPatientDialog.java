package com.horvat.console.dialogs.receptionist;

import com.horvat.bll.viewmodels.receptionist.InsertPatientViewModel;
import com.horvat.console.app.Utils;
import com.horvat.console.dialogs.base.Dialog;
import com.horvat.dl.entities.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import static com.horvat.console.app.Utils.enterString;

public class InsertPatientDialog extends Dialog<InsertPatientViewModel> {
    public InsertPatientDialog(String title, char underlineChar, InsertPatientViewModel viewModel) {
        super(title, underlineChar, viewModel);
    }

    @Override
    protected void askForInput() {
        String name = enterString("name");
        String sex = Utils.chooseOption(viewModel.getSexes()).getValue();
        Date dateOfBirth = Utils.readDateInPast("Enter date of birth", false);
        String statementOfComplaint = enterString("statement of complaint");
        String telephoneWork = enterString("work telephone");
        String telephoneHome = enterString("home telephone");
        String nameOfNextOfKin = enterString("Name of next of kin");

        if (viewModel.isBasic()) {
            viewModel.setBasicDetails(new BasicDetails(name, null, sex, dateOfBirth));
            viewModel.setBasicComplaints(new BasicComplaints(statementOfComplaint, null, null));
            viewModel.setContactDetails(new ContactDetails(null, null, new Contact(telephoneHome, telephoneWork, null, null, null, null)));
            viewModel.setContactOfNextOfKin(new ContactOfNextOfKin(nameOfNextOfKin, null, null));
        } else {
            String oib = enterString("OIB");

            viewModel.setBasicDetails(new BasicDetails(name, oib, sex, dateOfBirth));

            String presentAddress = enterString("present address");
            String permanentAddress = enterString("permanent address");
            String mobile = enterString("mobile telephone contact number");
            String pager = enterString("pager number");
            String fax = enterString("fax number");
            String email = enterString("email");

            viewModel.setContactDetails(new ContactDetails(presentAddress, permanentAddress, new Contact(telephoneHome, telephoneWork, mobile, pager, fax, email)));

            //nok = next of kin
            String nokContactAddress = enterString("contact address of next of kin");
            String nokTelephoneHome = enterString("home telephone of next of kin");
            String nokTelephoneWork = enterString("work telephone of next of kin");
            String nokMobile = enterString("mobile telephone contact number of next of kin");
            String nokPager = enterString("pager number of next of kin");
            String nokFax = enterString("fax number of next of kin");
            String nokEmail = enterString("email of next of kin");

            viewModel.setContactOfNextOfKin(new ContactOfNextOfKin(nameOfNextOfKin, nokContactAddress, new Contact(nokTelephoneHome, nokTelephoneWork, nokMobile, nokPager, nokFax, nokEmail)));

            Boolean married = Utils.readBoolean("Marital status");
            Integer numDependants = Utils.read(Integer::parseInt, input -> input > 0, "Enter number of dependants");
            Double height = Utils.readDouble(input -> input > 0, "Enter height");
            Double weight = Utils.readDouble(input -> input > 0, "Enter weight");
            String bloodTypeRH = enterString("blood type and RH factor (e.g. A+)");

            viewModel.setPersonalDetails(new PersonalDetails(married, numDependants, height, weight, bloodTypeRH));

            String occupation = enterString("occupation");
            BigDecimal grossAnnualIncome = Utils.readDecimal("Enter gross annual income");

            viewModel.setProfessionDetails(new ProfessionDetails(occupation, grossAnnualIncome));

            Boolean vegetarian = Utils.readBoolean("Vegetarian");
            Boolean smoker = Utils.readBoolean("Smoker");
            Boolean consumesAlcoholicBeverage = Utils.readBoolean("Consumes alcoholic beverage");
            Boolean usesStimulants = Utils.readBoolean("Uses stimulants");
            String stimulantsUsed = enterString("stimulants that the patient used");
            Double coffeeConsumptionPerDay = Utils.readDouble(input -> input > 0, "Enter patient's number of coffees consumed per day");
            Double teaConsumptionPerDay = Utils.readDouble(input -> input > 0, "Enter patient's number of teas consumed per day");
            Double softDrinkConsumptionPerDay = Utils.readDouble(input -> input > 0, "Enter patient's number of soft drinks consumed per day");
            Boolean regularMeals = Utils.readBoolean("Regular meals");
            String predominantEatingOption = Utils.chooseOption(viewModel.getPredominantEatingOptions()).getValue();

            viewModel.setLifestyle(new Lifestyle(vegetarian, smoker, consumesAlcoholicBeverage, usesStimulants, stimulantsUsed, coffeeConsumptionPerDay, teaConsumptionPerDay, softDrinkConsumptionPerDay, regularMeals, predominantEatingOption));

            String historyOfPreviousTreatment = enterString("history of previous treatment");
            String physicianOrHospitalTreated = enterString("physician or hospital that treated the patient");

            viewModel.setBasicComplaints(new BasicComplaints(statementOfComplaint, historyOfPreviousTreatment, physicianOrHospitalTreated));

            Boolean diabetic = Utils.readBoolean("Diabetic");
            Boolean hypertensive = Utils.readBoolean("Hypertensive");
            String cardiacCondition = enterString("cardiac condition");
            String respiratoryCondition = enterString("respiratory condition");
            String digestiveCondition = enterString("digestive condition");
            String orthopedicCondition = enterString("orthopedic condition");
            String muscularCondition = enterString("muscular condition");
            String neurologicalCondition = enterString("neurological condition");
            String knownAllergies = enterString("known allergies");
            String knownAdverseReactionsToSpecificDrugs = enterString("known adverse reactions to specific drugs");
            String majorSurgeries = enterString("major surgeries");

            viewModel.setMedicalComplaints(new MedicalComplaints(diabetic, hypertensive, cardiacCondition, respiratoryCondition, digestiveCondition, orthopedicCondition, muscularCondition, neurologicalCondition, knownAllergies, knownAdverseReactionsToSpecificDrugs, majorSurgeries));
        }

        dialogNavigator.goBackOnSuccess(this, () -> new ArrayList<Object>(){{
            add(viewModel.getPatient());
        }}, ReceptionistMenuDialog.class);
    }
}
