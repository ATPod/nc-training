package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Diagnosis;
import by.training.nc.dev5.clinic.entities.Patient;

import java.util.List;

/**
 * Created by user on 24.04.2017.
 */
public interface DiagnosisDAO {
    void add(Diagnosis temp);
    List<Diagnosis> getByPatient(Patient patient);
    void delete(int id);
}
