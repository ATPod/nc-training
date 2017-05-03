package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.dao.impl.DiagnosisMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DiagnosisService {
    public static List<Diagnosis> getByPatient(Patient patient)throws DAOException {
        return DiagnosisMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void add(Diagnosis diagnosis)throws DAOException{
        DiagnosisMySQLDAO.INSTANCE.add(diagnosis);
    }

    public static void delete(int id)throws DAOException{
        DiagnosisMySQLDAO.INSTANCE.delete(id);
    }
}
