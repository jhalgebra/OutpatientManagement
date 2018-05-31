package com.horvat.dal.data;

import com.horvat.dal.entities.*;
import com.lib.dal.access.DBExecutor;
import com.lib.dal.entities.DBConfig;
import com.lib.dal.entities.SQLParameter;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class DatabaseRepository implements IRepository {
    //region Converters

    private final Function<Object[], Pair<Integer, String>> enumConverter = data ->
            new Pair<>((Integer) data[0], (String) data[1]);
    private final Function<Object[], Patient> patientConverter =
            new Patient().getConverter();
    private final Function<Object[], Bill> billConverter =
            new Bill().getConverter();
    private final Function<Object[], Appointment> appointmentConverter =
            new Appointment().getConverter();
    private final Function<Object[], Test> testConverter =
            new Test().getConverter();
    private final Function<Object[], PrescribedMedicine> medicineConverter =
            new PrescribedMedicine().getConverter();
    private final Function<Object[], Doctor> doctorConverter =
            new Doctor().getConverter();

    //endregion

    private DBExecutor executor;

    DatabaseRepository(String xmlFilePath) throws Exception {
        DBConfig config = new DBConfig(xmlFilePath);

        executor = new DBExecutor(config);
    }

    //region Patient

    @Override
    public Patient insertPatientWithBasicDetails(String name, Integer sexID, Date dateOfBirth, String statementOfComplaint, String telephoneWork, String telephoneHome, String nameOfNextOfKin) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);
            SQLParameter<Date> insertedRegistrationDate = new SQLParameter<>(Types.DATE);
            SQLParameter<String> insertedSex = new SQLParameter<>(Types.NVARCHAR);

            if (executor.executeProcedure(
                    "InsertPatientWithBasicDetails",
                    new SQLParameter<>(name),
                    new SQLParameter<>(sexID),
                    new SQLParameter<>(dateOfBirth),
                    new SQLParameter<>(statementOfComplaint),
                    new SQLParameter<>(telephoneWork),
                    new SQLParameter<>(telephoneHome),
                    new SQLParameter<>(nameOfNextOfKin),
                    insertedID,
                    insertedRegistrationDate,
                    insertedSex
            ) <= 0) return null;

            else return new Patient(
                    insertedID.getValue(),
                    insertedRegistrationDate.getValue(),
                    true,
                    null,
                    null,
                    null,
                    null,
                    new BasicDetails(name, null, insertedSex.getValue(), dateOfBirth),
                    new ContactDetails(null, null, new Contact(telephoneHome, telephoneWork, null, null, null, null)),
                    new ContactOfNextOfKin(nameOfNextOfKin, null, null),
                    null,
                    null,
                    null,
                    new BasicComplaints(statementOfComplaint, null, null),
                    null
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Patient insertPatientWithFullDetails(BasicDetails basicDetails, ContactDetails contactDetails, ContactOfNextOfKin contactOfNextOfKin, PersonalDetails personalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints medicalComplaints) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);
            SQLParameter<Date> insertedRegistrationDate = new SQLParameter<>(Types.DATE);
            SQLParameter<String> insertedSex = new SQLParameter<>(Types.NVARCHAR);

            Integer sexID = -1;
            for (Pair<Integer, String> sex : getSexes()) {
                if (sex.getValue().equals(basicDetails.getSex())) {
                    sexID = sex.getKey();
                    break;
                }
            }

            Integer predominantEatingOptionID = -1;
            for (Pair<Integer, String> predominantEatingOption : getPredominantEatingOptions()) {
                if (predominantEatingOption.getValue().equals(lifestyle.getPredominantEatingOption())) {
                    predominantEatingOptionID = predominantEatingOption.getKey();
                    break;
                }
            }

            if (executor.executeProcedure(
                    "InsertPatientWithFullDetails",
                    new SQLParameter<>(basicDetails.getOib()),
                    new SQLParameter<>(basicDetails.getName()),
                    new SQLParameter<>((Integer)sexID),
                    new SQLParameter<>(basicDetails.getDateOfBirth()),

                    new SQLParameter<>(contactDetails.getPresentAddress()),
                    new SQLParameter<>(contactDetails.getPermanentAddress()),
                    new SQLParameter<>(contactDetails.getContact().getTelephoneWork()),
                    new SQLParameter<>(contactDetails.getContact().getTelephoneHome()),
                    new SQLParameter<>(contactDetails.getContact().getMobile()),
                    new SQLParameter<>(contactDetails.getContact().getPager()),
                    new SQLParameter<>(contactDetails.getContact().getFax()),
                    new SQLParameter<>(contactDetails.getContact().getEmail()),

                    new SQLParameter<>(contactOfNextOfKin.getName()),
                    new SQLParameter<>(contactOfNextOfKin.getContactAddress()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getTelephoneWork()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getTelephoneHome()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getMobile()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getPager()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getFax()),
                    new SQLParameter<>(contactOfNextOfKin.getContact().getEmail()),

                    new SQLParameter<>(personalDetails.isMarried()),
                    new SQLParameter<>(personalDetails.getNumberOfDependents()),
                    new SQLParameter<>(personalDetails.getHeight()),
                    new SQLParameter<>(personalDetails.getWeight()),
                    new SQLParameter<>(personalDetails.getBloodTypeRH()),

                    new SQLParameter<>(professionDetails.getOccupation()),
                    new SQLParameter<>(professionDetails.getGrossAnnualIncome()),

                    new SQLParameter<>(lifestyle.isVegeterian()),
                    new SQLParameter<>(lifestyle.isSmoker()),
                    new SQLParameter<>(lifestyle.isConsumesAlcoholicBeverage()),
                    new SQLParameter<>(lifestyle.isUsesStimulants()),
                    new SQLParameter<>(lifestyle.getStimulantsUsed()),
                    new SQLParameter<>(lifestyle.getCoffeeConsumptionPerDay()),
                    new SQLParameter<>(lifestyle.getTeaConsumptionPerDay()),
                    new SQLParameter<>(lifestyle.getSoftDrinkConsumptionPerDay()),
                    new SQLParameter<>(lifestyle.isRegularMeals()),
                    new SQLParameter<>(predominantEatingOptionID),

                    new SQLParameter<>(basicComplaints.getStatementOfComplaint()),
                    new SQLParameter<>(basicComplaints.getHistoryOfPreviousTreatment()),
                    new SQLParameter<>(basicComplaints.getPhysicianOrHospitalTreated()),

                    new SQLParameter<>(medicalComplaints.isDiabetic()),
                    new SQLParameter<>(medicalComplaints.isHypertensive()),
                    new SQLParameter<>(medicalComplaints.getCardiacCondition()),
                    new SQLParameter<>(medicalComplaints.getRespiratoryCondition()),
                    new SQLParameter<>(medicalComplaints.getDigestiveCondition()),
                    new SQLParameter<>(medicalComplaints.getOrthopedicCondition()),
                    new SQLParameter<>(medicalComplaints.getMuscularCondition()),
                    new SQLParameter<>(medicalComplaints.getNeurologicalCondition()),
                    new SQLParameter<>(medicalComplaints.getKnownAllergies()),
                    new SQLParameter<>(medicalComplaints.getKnownAdverseReactionToSpecificDrugs()),
                    new SQLParameter<>(medicalComplaints.getMajorSurgeries()),

                    insertedID,
                    insertedRegistrationDate,
                    insertedSex
            ) <= 0) return null;

            else return new Patient(
                    insertedID.getValue(),
                    insertedRegistrationDate.getValue(),
                    false,
                    null,
                    null,
                    null,
                    null,
                    basicDetails,
                    contactDetails,
                    contactOfNextOfKin,
                    personalDetails,
                    professionDetails,
                    lifestyle,
                    basicComplaints,
                    medicalComplaints
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean removePatient(Integer patientID) {
        try {
            return executor.executeProcedure("RemovePatient", new SQLParameter<>(patientID)) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Patient> getPatients() {
        try {
            List<Patient> patients = executor.executeProcedure(
                    "GetPatients",
                    patientConverter
            );

            for (Patient patient : patients) {
                patient.setBills(getBills(patient.getId()));
                patient.setAppointments(getAppointments(patient.getId()));
                patient.setTests(getTests(patient.getId()));
                patient.setPrescribedMedicine(getPrescribedMedicine(patient.getId()));
            }

            return patients;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //endregion

    //region Bill

    @Override
    public Bill insertBill(String paymentType, Integer patientID, BigDecimal amount) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);
            SQLParameter<Date> insertedDateIssued = new SQLParameter<>(Types.DATE);

            Integer paymentTypeID = -1;
            for (Pair<Integer, String> payment : getPaymentTypes()) {
                if (payment.getValue().equals(paymentType)) {
                    paymentTypeID = payment.getKey();
                    break;
                }
            }

            if (executor.executeProcedure(
                    "InsertBill",
                    new SQLParameter<>(paymentTypeID),
                    new SQLParameter<>(patientID),
                    new SQLParameter<>(amount),
                    insertedID,
                    insertedDateIssued
            ) <= 0) return null;

            else return new Bill(
                    insertedID.getValue(),
                    insertedDateIssued.getValue(),
                    paymentType,
                    amount
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean removeBill(Integer billID) {
        try {
            return executor.executeProcedure("RemoveBill", new SQLParameter<>(billID)) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Bill> getBills(Integer patientID) {
        try {
            return executor.executeProcedure(
                    "GetBills",
                    billConverter,
                    new SQLParameter<>(patientID)
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //endregion

    //region Appointment

    @Override
    public Appointment insertAppointment(Integer doctorID, Integer patientID, String delegate, Date dateAppointed, String details) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);

            if (executor.executeProcedure(
                    "InsertAppointment",
                    new SQLParameter<>(doctorID),
                    new SQLParameter<>(patientID),
                    new SQLParameter<>(delegate),
                    new SQLParameter<>(dateAppointed),
                    new SQLParameter<>(details),
                    insertedID
            ) <= 0) return null;

            String doctorName = null;
            for (Doctor doctor : getDoctors()) {
                if (doctor.getId().equals(doctorID)) {
                    doctorName = doctor.getBasicDetails().getName();
                    break;
                }
            }

            return new Appointment(
                    insertedID.getValue(),
                    doctorID,
                    delegate,
                    dateAppointed,
                    details,
                    doctorName
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean removeAppointment(Integer appointmentID) {
        try {
            return executor.executeProcedure(
                    "RemoveAppointment",
                    new SQLParameter<>(appointmentID)
            ) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Appointment> getAppointments(Integer patientID) {
        try {
            return executor.executeProcedure(
                    "GetAppointments",
                    appointmentConverter,
                    new SQLParameter<>(patientID)
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //endregion

    //region Test

    @Override
    public Test insertTest(Integer patientID, Integer doctorID, String name, String details, Date testDateTime) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);

            if (executor.executeProcedure(
                    "InsertTest",
                    new SQLParameter<>(patientID),
                    new SQLParameter<>(doctorID),
                    new SQLParameter<>(name),
                    new SQLParameter<>(details),
                    new SQLParameter<>(testDateTime),
                    insertedID
            ) <= 0) return null;

            String doctorName = null;
            for (Doctor doctor : getDoctors()) {
                if (doctor.getId().equals(doctorID)) {
                    doctorName = doctor.getBasicDetails().getName();
                    break;
                }
            }

            return new Test(
                    insertedID.getValue(),
                    doctorID,
                    name,
                    doctorName,
                    testDateTime,
                    details
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean removeTest(Integer testID) {
        try {
            return executor.executeProcedure(
                    "RemoveTest",
                    new SQLParameter<>(testID)
            ) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Test> getTests(Integer patientID) {
        try {
            return executor.executeProcedure(
                    "GetTests",
                    testConverter,
                    new SQLParameter<>(patientID)
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //endregion

    //region PrescribedMedicine

    @Override
    public PrescribedMedicine insertPrescribedMedicine(Double quantity, String medicineName, Integer patientID, Integer doctorID) {
        try {
            SQLParameter<Integer> insertedID = new SQLParameter<>(Types.INTEGER);
            SQLParameter<Date> insertedDateIssued = new SQLParameter<>(Types.DATE);

            Integer medicineID = -1;
            for (Pair<Integer, String> medicine : getMedicines()) {
                if (medicine.getValue().equals(medicineName)) {
                    medicineID = medicine.getKey();
                    break;
                }
            }

            if (executor.executeProcedure(
                    "InsertPatientMedicine",
                    new SQLParameter<>(quantity),
                    new SQLParameter<>(medicineID),
                    new SQLParameter<>(patientID),
                    new SQLParameter<>(doctorID),
                    insertedID,
                    insertedDateIssued
            ) <= 0) return null;

            String doctorName = null;
            for (Doctor doctor : getDoctors()) {
                if (doctor.getId().equals(doctorID)) {
                    doctorName = doctor.getBasicDetails().getName();
                    break;
                }
            }

            return new PrescribedMedicine(
                    insertedID.getValue(),
                    doctorID,
                    medicineName,
                    quantity,
                    insertedDateIssued.getValue(),
                    doctorName
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean removePrescribedMedicine(Integer prescribedMedicineID) {
        try {
            return executor.executeProcedure(
                    "RemovePatientMedicine",
                    new SQLParameter<>(prescribedMedicineID)
            ) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PrescribedMedicine> getPrescribedMedicine(Integer patientID) {
        try {
            return executor.executeProcedure(
                    "GetPatientMedicine",
                    medicineConverter,
                    new SQLParameter<>(patientID));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //endregion

    @Override
    public List<Doctor> getDoctors() {
        try {
            return executor.executeProcedure(
                    "GetDoctors",
                    doctorConverter
            );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    //region "Enums"

    @Override
    public List<Pair<Integer, String>> getPaymentTypes() {
        return executor.executeProcedure("GetPaymentTypes", enumConverter);
    }

    @Override
    public List<Pair<Integer, String>> getPredominantEatingOptions() {
        return executor.executeProcedure("GetPredominantEatingOptions", enumConverter);
    }

    @Override
    public List<Pair<Integer, String>> getSexes() {
        return executor.executeProcedure("GetSexes", enumConverter);
    }

    @Override
    public List<Pair<Integer, String>> getMedicines() {
        return executor.executeProcedure("GetMedicines", enumConverter);
    }

    //endregion
}
