package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.Drug;
import by.training.nc.dev5.clinic.dao.DrugMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DrugService {
    public static List<Drug> getByPatient(Patient patient)throws DAOException {
        return DrugMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void delete(int id) throws DAOException{
        DrugMySQLDAO.INSTANCE.delete(id);
    }

    public static void add(Drug drug)throws DAOException{
        DrugMySQLDAO.INSTANCE.add(drug);
    }

}
