package com.horvat.bll.models;

import com.horvat.bll.helpers.DateWithin;
import com.horvat.bll.helpers.Utils;
import com.horvat.dal.IRepository;
import com.horvat.dal.RepositoryFactory;
import com.horvat.dl.entities.Appointment;
import com.horvat.dl.entities.Doctor;
import com.horvat.dl.entities.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PatientReport {
    private IRepository repository = RepositoryFactory.getRepository();
    private DateWithin reportRange;

    public PatientReport(DateWithin reportRange) {
        this.reportRange = reportRange;
    }

    public long getNumNewOrSecondOpinionPatients() {
        return repository.getPatients().stream()
                .filter(patient -> patient.getAppointments().stream().anyMatch(
                        appointment -> appointment.getSecondOpinion() &&
                                Utils.dateWithin(reportRange, appointment.getDate())) ||

                        Utils.dateWithin(reportRange, patient.getRegistrationDate())
                )
                .count();
    }

    public Map<Doctor, Double> getNumPatientsForDoctors() {
        Map<Doctor, Double> numPatientsPerDoctor = new HashMap<>();

        List<Doctor> doctors = repository.getDoctors();
        List<Patient> patients = repository.getPatients();

        //Weekly or monthly report variables
        int i = 0;
        Double sum = 0.0;
        Double[] countPerDoctor = new Double[doctors.size()];

        for (Doctor doctor : doctors) {

            Double count = 0.0;
            for (Patient patient : patients) {

                List<Appointment> filteredAppointments =
                        patient.getAppointments().stream()
                                .filter(appointment -> Utils.dateWithin(reportRange, appointment.getDate()))
                                .collect(Collectors.toList());

                for (Appointment appointment : filteredAppointments) {
                    if (doctor.getId().equals(appointment.getDoctorID())) {
                        count++;
                        break;
                    }
                }

            }

            if (reportRange == DateWithin.TODAY)
                numPatientsPerDoctor.put(doctor, count);
            else {
                sum += count;
                countPerDoctor[i] = count;
            }

            i++;
        }

        if (reportRange == DateWithin.THIS_WEEK || reportRange == DateWithin.THIS_MONTH)
            for (i = 0; i < doctors.size(); i++) {
                Double average = countPerDoctor[i] / sum;

                numPatientsPerDoctor.put(doctors.get(i), average.isNaN() ? 0.0 : average * 100);
            }

        return numPatientsPerDoctor;
    }
}
