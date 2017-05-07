package by.training.nc.dev5.clinic.services.impls;

import by.training.nc.dev5.clinic.entities.prescribings.Drug;
import by.training.nc.dev5.clinic.dao.impl.DrugMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DrugService {
    public static List<Drug> getByPatient(Patient patient)throws DAOException {
        return DrugMySQLDAO.getInstance().getByPatient(patient);
    }

    public static void delete(int id) throws DAOException{
        DrugMySQLDAO.getInstance().delete(id);
    }

    public static void add(Drug drug)throws DAOException{
        DrugMySQLDAO.getInstance().add(drug);
    }

}
