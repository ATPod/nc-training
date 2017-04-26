package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.interfaces.PatientDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  PatientMySQLDAO implements PatientDAO{
    INSTANCE;
    public List<Patient> getAll(){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Patient.findAll");
            return (List<Patient>) query.getResultList();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            return new ArrayList<Patient>();
        }
    }

    public void add(Patient patient){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(patient);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }

    public void delete(int patientId){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Patient patient = entityManager.find(Patient.class, patientId);
            entityManager.getTransaction().begin();
            entityManager.remove(patient);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }

    public Patient getById(int patientId){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.find(Patient.class, patientId);
    }

    public Patient getByName(String name){
        List<Patient> patientList;
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Patient.getByName");
            query.setParameter(1, name);
            patientList = (List<Patient>) query.getResultList();
            return patientList.get(0);
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            return null;
        }
    }

}
