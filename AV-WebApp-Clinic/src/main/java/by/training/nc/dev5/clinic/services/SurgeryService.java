package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.dao.impl.SurgeryMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class SurgeryService {

    public static List<Surgery> getByPatient(Patient patient)throws DAOException {
        return SurgeryMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void add(Surgery surgery)throws DAOException{
        SurgeryMySQLDAO.INSTANCE.add(surgery);
    }

    public static void delete(int id)throws DAOException{
        SurgeryMySQLDAO.INSTANCE.delete(id);
    }
}
