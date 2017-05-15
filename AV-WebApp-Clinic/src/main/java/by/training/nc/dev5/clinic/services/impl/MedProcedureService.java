package by.training.nc.dev5.clinic.services.impl;

import by.training.nc.dev5.clinic.dao.IMedProcedureDAO;
import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.impl.MedProcedureMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.services.IMedProcedureService;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class MedProcedureService implements IMedProcedureService {
    private static MedProcedureService instance;

    public static synchronized MedProcedureService getInstance(){
        if(instance == null){
            instance = new MedProcedureService();
        }
        return instance;
    }

    public List<MedProcedure> getByPatient(Patient patient)throws DAOException {
        return MedProcedureMySQLDAO.getInstance().getByPatient(patient);
    }

    public void delete(int id)throws DAOException{
        MedProcedureMySQLDAO.getInstance().delete(id);
    }

    public void add(MedProcedure medProcedure)throws DAOException{
        MedProcedureMySQLDAO.getInstance().add(medProcedure);
    }
}
