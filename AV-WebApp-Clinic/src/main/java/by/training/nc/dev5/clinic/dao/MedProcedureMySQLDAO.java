package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.MedProcedure;
import by.training.nc.dev5.clinic.dao.interfaces.MedProcedureDAO;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import by.training.nc.dev5.clinic.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum MedProcedureMySQLDAO implements MedProcedureDAO {
    INSTANCE;

    public List<MedProcedure> getByPatient(Patient patient)throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("MedProcedure.getByPatient");
            query.setParameter(1, patient);
            return (List<MedProcedure>) query.getResultList();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void add(MedProcedure medProcedure)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(medProcedure);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void delete(int id) throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            MedProcedure medProcedure = entityManager.find(MedProcedure.class, id);
            entityManager.getTransaction().begin();
            entityManager.remove(medProcedure);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
