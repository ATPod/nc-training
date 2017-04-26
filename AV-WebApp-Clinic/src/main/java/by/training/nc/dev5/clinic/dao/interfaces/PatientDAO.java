package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Patient;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public interface PatientDAO {
    void add(Patient patient);
    void delete(int patientId);
    List<Patient> getAll();
    Patient getById(int patientId);
    Patient getByName(String name);
}
