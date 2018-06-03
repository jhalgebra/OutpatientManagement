package com.horvat.dal;

import com.horvat.dl.entities.*;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.Function;

public class Converters {
    //region Fields

    private static final Function<Object[], Pair<Integer, String>> enumConverter =
            data -> new Pair<>(
                    (Integer) data[0],
                    (String) data[1]
            );

    private static final Function<Object[], Appointment> appointmentConverter =
            data -> new Appointment(
                    (Integer) data[0],
                    (Integer) data[1],
                    (String) data[2],
                    (Date) data[3],
                    (String) data[4],
                    (String) data[5],
                    (Boolean)data[6]
            );

    private static final Function<Object[], Bill> billConverter =
            data -> new Bill(
                    (Integer) data[0],
                    (Date) data[1],
                    (String) data[2],
                    (BigDecimal) data[3]
            );

    private static final Function<Object[], Doctor> doctorConverter =
            data -> new Doctor(
                    (Integer) data[0],
                    new BasicDetails(
                            (String) data[1],
                            (String) data[2],
                            (String) data[3],
                            (Date) data[4]
                    )
            );

    private static final Function<Object[], PrescribedMedicine> medicineConverter =
            data -> new PrescribedMedicine(
                    (Integer) data[0],
                    (Integer) data[1],
                    (String) data[2],
                    (Double) data[3],
                    (Date) data[4],
                    (String) data[5]
            );

    public static final Function<Object[], Test> testConverter =
            data -> new Test(
                    (Integer) data[0],
                    (Integer) data[1],
                    (String) data[2],
                    (String) data[3],
                    (Date) data[4],
                    (String) data[5]
            );

    private static final Function<Object[], Patient> patientConverter =
            data -> new Patient(
                    (Integer) data[0],
                    (Date) data[1],
                    (Boolean) data[2],
                    null,
                    null,
                    null,
                    null,
                    new BasicDetails(
                            (String) data[3],
                            (String) data[4],
                            (String) data[5],
                            (Date) data[6]
                    ),
                    new ContactDetails(
                            (String) data[7],
                            (String) data[8],
                            new Contact(
                                    (String) data[9],
                                    (String) data[10],
                                    (String) data[11],
                                    (String) data[12],
                                    (String) data[13],
                                    (String) data[14]
                            )
                    ),
                    new ContactOfNextOfKin(
                            (String) data[15],
                            (String) data[16],
                            new Contact(
                                    (String) data[17],
                                    (String) data[18],
                                    (String) data[19],
                                    (String) data[20],
                                    (String) data[21],
                                    (String) data[22]
                            )
                    ),
                    new PersonalDetails(
                            (Boolean) data[23],
                            (Integer) data[24],
                            (Double) data[25],
                            (Double) data[26],
                            (String) data[27]
                    ),
                    new ProfessionDetails(
                            (String) data[28],
                            (BigDecimal) data[29]
                    ),
                    new Lifestyle(
                            (Boolean) data[30],
                            (Boolean) data[31],
                            (Boolean) data[32],
                            (Boolean) data[33],
                            (String) data[34],
                            (Double) data[35],
                            (Double) data[36],
                            (Double) data[37],
                            (Boolean) data[38],
                            (String) data[39]
                    ),
                    new BasicComplaints(
                            (String) data[40],
                            (String) data[41],
                            (String) data[42]
                    ),
                    new MedicalComplaints(
                            (Boolean) data[43],
                            (Boolean) data[44],
                            (String) data[45],
                            (String) data[46],
                            (String) data[47],
                            (String) data[48],
                            (String) data[49],
                            (String) data[50],
                            (String) data[51],
                            (String) data[52],
                            (String) data[53]
                    )
            );

    //endregion

    public static Function<Object[], Pair<Integer, String>> getEnumConverter() {
        return enumConverter;
    }

    public static Function<Object[], Appointment> getAppointmentConverter() {
        return appointmentConverter;
    }

    public static Function<Object[], Bill> getBillConverter() {
        return billConverter;
    }

    public static Function<Object[], Doctor> getDoctorConverter() {
        return doctorConverter;
    }

    public static Function<Object[], PrescribedMedicine> getMedicineConverter() {
        return medicineConverter;
    }

    public static Function<Object[], Test> getTestConverter() {
        return testConverter;
    }

    public static Function<Object[], Patient> getPatientConverter() {
        return patientConverter;
    }
}
