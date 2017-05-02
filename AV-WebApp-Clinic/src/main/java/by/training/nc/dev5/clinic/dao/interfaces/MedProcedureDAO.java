package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.MedProcedure;

import java.util.List;
import by.training.nc.dev5.clinic.exceptions.*;
/**
 * Created by user on 24.04.2017.
 */
public interface MedProcedureDAO {
    void add(MedProcedure temp)throws DAOException;
    List<MedProcedure> getByPatient(Patient patient)throws DAOException;
    void delete(int id)throws DAOException;
}
