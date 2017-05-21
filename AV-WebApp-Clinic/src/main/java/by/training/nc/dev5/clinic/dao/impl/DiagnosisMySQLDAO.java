package by.training.nc.dev5.clinic.dao.impl;

import by.training.nc.dev5.clinic.dao.AbstractDAO;
import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.dao.IDiagnosisDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import by.training.nc.dev5.clinic.exceptions.*;
/**
 * Created by user on 06.04.2017.
 */
public class  DiagnosisMySQLDAO extends AbstractDAO<Diagnosis> implements IDiagnosisDAO {
    private static DiagnosisMySQLDAO instance;

    private DiagnosisMySQLDAO(){
        super(Diagnosis.class);
    }

    public List<Diagnosis> getByPatient(Patient patient)throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Diagnosis.getByPatient");
            query.setParameter(1, patient);
            return (List<Diagnosis>) query.getResultList();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public static synchronized DiagnosisMySQLDAO getInstance(){
        if(instance == null){
            instance = new DiagnosisMySQLDAO();
        }
        return instance;
    }

}

