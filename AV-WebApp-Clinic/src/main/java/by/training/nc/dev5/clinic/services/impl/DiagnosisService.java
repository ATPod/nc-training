package by.training.nc.dev5.clinic.services.impl;

import by.training.nc.dev5.clinic.dao.AbstractDAO;
import by.training.nc.dev5.clinic.dao.IDiagnosisDAO;
import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.dao.impl.DiagnosisMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.services.IDiagnosisService;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DiagnosisService implements IDiagnosisService {
    private static DiagnosisService instance;

    public static synchronized DiagnosisService getInstance(){
        if(instance == null){
            instance = new DiagnosisService();
        }
        return instance;
    }

    public List<Diagnosis> getByPatient(Patient patient)throws DAOException {
        return DiagnosisMySQLDAO.getInstance().getByPatient(patient);
    }

    public void add(Diagnosis diagnosis)throws DAOException{
        DiagnosisMySQLDAO.getInstance().add(diagnosis);
    }

    public void delete(int id)throws DAOException{
        DiagnosisMySQLDAO.getInstance().delete(id);
    }
}
