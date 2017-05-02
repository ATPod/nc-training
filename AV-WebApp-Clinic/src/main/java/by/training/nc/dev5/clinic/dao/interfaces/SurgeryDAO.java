package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.Surgery;
import by.training.nc.dev5.clinic.exceptions.*;
import java.util.List;

/**
 * Created by user on 24.04.2017.
 */
public interface SurgeryDAO {
    void add(Surgery temp)throws DAOException;
    List<Surgery> getByPatient(Patient patient)throws DAOException;
    void delete(int id)throws DAOException;
}
