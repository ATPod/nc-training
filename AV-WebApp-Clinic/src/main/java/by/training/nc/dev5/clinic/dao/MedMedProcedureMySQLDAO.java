package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.MedProcedure;
import by.training.nc.dev5.clinic.dao.interfaces.MedProcedureDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum MedMedProcedureMySQLDAO implements MedProcedureDAO {
    INSTANCE;

    public List<MedProcedure> getByPatient(Patient patient){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("MedProcedure.getByPatient");
            query.setParameter(1, patient);
            return (List<MedProcedure>) query.getResultList();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            return new ArrayList<MedProcedure>();
        }
    }

    public void add(MedProcedure medProcedure){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(medProcedure);
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
            MedProcedure medProcedure = entityManager.find(MedProcedure.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(medProcedure);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }
}
