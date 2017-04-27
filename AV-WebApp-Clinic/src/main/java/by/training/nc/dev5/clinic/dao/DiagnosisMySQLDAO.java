package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Diagnosis;
import by.training.nc.dev5.clinic.dao.interfaces.DiagnosisDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  DiagnosisMySQLDAO implements DiagnosisDAO{
    INSTANCE;

    public List<Diagnosis> getByPatient(Patient patient){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Diagnosis.getByPatient");
            query.setParameter(1, patient);
            return (List<Diagnosis>) query.getResultList();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            return new ArrayList<Diagnosis>();
        }
    }

    public void add(Diagnosis diagnosis){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(diagnosis);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }

    public void delete(int id){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Diagnosis diagnosis = entityManager.find(Diagnosis.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(diagnosis);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }

}

