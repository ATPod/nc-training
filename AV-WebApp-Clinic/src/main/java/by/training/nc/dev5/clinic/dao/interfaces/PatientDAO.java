package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.beans.patient.Patient;

import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public interface PatientDAO {
    //void add(String name);
    //void delete(int patientId);
    List<Patient> getAll();
    //Patient getById(int patientId);
}
