package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.Surgery;
import by.training.nc.dev5.clinic.dao.interfaces.SurgeryDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  SurgeryMySQLDAO implements SurgeryDAO {
    INSTANCE;
    public List<Surgery> getByPatient(Patient patient){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Surgery.getByPatient");
            query.setParameter(1, patient);
            return (List<Surgery>) query.getResultList();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            return new ArrayList<Surgery>();
        }
    }

    public void add(Surgery surgery){
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(surgery);
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
            Surgery surgery = entityManager.find(Surgery.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(surgery);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
    }
}
