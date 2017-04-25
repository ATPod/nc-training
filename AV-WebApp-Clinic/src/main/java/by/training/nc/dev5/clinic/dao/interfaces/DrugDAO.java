package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Drug;
import by.training.nc.dev5.clinic.entities.Patient;

import java.util.List;

/**
 * Created by user on 24.04.2017.
 */
public interface DrugDAO {
    void add(Drug temp);
    List<Drug> getByPatient(Patient patient);
    void delete(int id);
}
