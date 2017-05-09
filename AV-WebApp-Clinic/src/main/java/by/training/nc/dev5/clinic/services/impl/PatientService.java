package by.training.nc.dev5.clinic.services.impl;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.impl.PatientMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.exceptions.NotFoundException;
import by.training.nc.dev5.clinic.services.IPatientService;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class PatientService implements IPatientService{
    private static PatientService instance;

    public static synchronized PatientService getInstance(){
        if(instance == null){
            instance = new PatientService();
        }
        return instance;
    }

    public List<Patient> getAll()throws DAOException {
        return PatientMySQLDAO.getInstance().getAll();
    }

    public boolean isNewPatient(String name)throws DAOException{
        try {
            PatientMySQLDAO.getInstance().getByName(name);
            return false;
        } catch (NotFoundException e){
            return true;
        }
    }

    public void add(Patient patient)throws DAOException{
        PatientMySQLDAO.getInstance().add(patient);
    }

    public Patient getById(int id)throws DAOException {
        return PatientMySQLDAO.getInstance().getById(id);
    }

    public void delete(int id)throws DAOException{
        PatientMySQLDAO.getInstance().delete(id);
    }
}
