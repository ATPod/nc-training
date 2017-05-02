package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.PatientMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.exceptions.NotFoundException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class PatientService {
    public static List<Patient> getAll()throws DAOException {
        return PatientMySQLDAO.INSTANCE.getAll();
    }

    public static boolean isNewPatient(String name)throws DAOException{
        try {
            PatientMySQLDAO.INSTANCE.getByName(name);
            return false;
        } catch (NotFoundException e){
            return true;
        }
    }

    public static void add(Patient patient)throws DAOException{
        PatientMySQLDAO.INSTANCE.add(patient);
    }

    public static Patient getById(int patientId)throws DAOException {
        return PatientMySQLDAO.INSTANCE.getById(patientId);
    }

    public static void delete(int patientId)throws DAOException{
        PatientMySQLDAO.INSTANCE.delete(patientId);
    }
}
