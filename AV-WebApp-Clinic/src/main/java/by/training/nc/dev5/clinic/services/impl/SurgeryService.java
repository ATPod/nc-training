package by.training.nc.dev5.clinic.services.impl;

import by.training.nc.dev5.clinic.dao.ISurgeryDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.dao.impl.SurgeryMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.services.ISurgeryService;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class SurgeryService implements ISurgeryService{
    private static SurgeryService instance;

    public static synchronized SurgeryService getInstance(){
        if(instance == null){
            instance = new SurgeryService();
        }
        return instance;
    }

    public List<Surgery> getByPatient(Patient patient)throws DAOException {
        return SurgeryMySQLDAO.getInstance().getByPatient(patient);
    }

    public void add(Surgery surgery)throws DAOException{
        SurgeryMySQLDAO.getInstance().add(surgery);
    }

    public void delete(int id)throws DAOException{
        SurgeryMySQLDAO.getInstance().delete(id);
    }
}
