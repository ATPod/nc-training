package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Drug;
import by.training.nc.dev5.clinic.dao.interfaces.DrugDAO;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import by.training.nc.dev5.clinic.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  DrugMySQLDAO implements DrugDAO {
    INSTANCE;

    public List<Drug> getByPatient(Patient patient)throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Drug.getByPatient");
            query.setParameter(1, patient);
            return (List<Drug>) query.getResultList();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void add(Drug drug)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {

            entityManager.getTransaction().begin();
            entityManager.persist(drug);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void delete(int id) throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Drug drug = entityManager.find(Drug.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(drug);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
