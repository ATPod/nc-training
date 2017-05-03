package by.training.nc.dev5.clinic.dao.impl;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.dao.SurgeryDAO;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import by.training.nc.dev5.clinic.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  SurgeryMySQLDAO implements SurgeryDAO {
    INSTANCE;
    public List<Surgery> getByPatient(Patient patient)throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Surgery.getByPatient");
            query.setParameter(1, patient);
            return (List<Surgery>) query.getResultList();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void add(Surgery surgery)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(surgery);
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new DAOException(e.getMessage());
        }finally {
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
    }

    public void delete(int id) throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Surgery surgery = entityManager.find(Surgery.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(surgery);
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new DAOException(e.getMessage());
        }finally {
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
    }
}
