package by.training.nc.dev5.clinic.services.impl;

import by.training.nc.dev5.clinic.entities.prescribings.Drug;
import by.training.nc.dev5.clinic.dao.impl.DrugMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.services.IDrugService;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DrugService implements IDrugService{
    private static DrugService instance;

    public static synchronized DrugService getInstance(){
        if(instance == null){
            instance = new DrugService();
        }
        return instance;
    }

    public List<Drug> getByPatient(Patient patient)throws DAOException {
        return DrugMySQLDAO.getInstance().getByPatient(patient);
    }

    public void delete(int id) throws DAOException{
        DrugMySQLDAO.getInstance().delete(id);
    }

    public void add(Drug drug)throws DAOException{
        DrugMySQLDAO.getInstance().add(drug);
    }

}
