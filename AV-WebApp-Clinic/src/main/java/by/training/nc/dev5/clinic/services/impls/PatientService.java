package by.training.nc.dev5.clinic.services.impls;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.impl.PatientMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.exceptions.NotFoundException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class PatientService {
    public static List<Patient> getAll()throws DAOException {
        return PatientMySQLDAO.getInstance().getAll();
    }

    public static boolean isNewPatient(String name)throws DAOException{
        try {
            PatientMySQLDAO.getInstance().getByName(name);
            return false;
        } catch (NotFoundException e){
            return true;
        }
    }

    public static void add(Patient patient)throws DAOException{
        PatientMySQLDAO.getInstance().add(patient);
    }

    public static Patient getById(int patientId)throws DAOException {
        return PatientMySQLDAO.getInstance().getById(patientId);
    }

    public static void delete(int patientId)throws DAOException{
        PatientMySQLDAO.getInstance().delete(patientId);
    }
}
