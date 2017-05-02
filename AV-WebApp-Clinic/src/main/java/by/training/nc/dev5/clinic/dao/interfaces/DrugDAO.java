package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Drug;
import by.training.nc.dev5.clinic.entities.Patient;

import java.util.List;
import by.training.nc.dev5.clinic.exceptions.*;
/**
 * Created by user on 24.04.2017.
 */
public interface DrugDAO {
    void add(Drug temp)throws DAOException;
    List<Drug> getByPatient(Patient patient)throws DAOException;
    void delete(int id)throws DAOException;
}
