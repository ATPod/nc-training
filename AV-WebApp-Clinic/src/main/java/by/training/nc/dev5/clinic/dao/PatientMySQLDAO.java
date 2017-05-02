package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.interfaces.PatientDAO;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import by.training.nc.dev5.clinic.exceptions.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  PatientMySQLDAO implements PatientDAO{
    INSTANCE;

    public List<Patient> getAll()throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Patient.findAll");
            return (List<Patient>) query.getResultList();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }


    public void add(Patient patient)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(patient);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public void delete(int patientId)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            Patient patient = entityManager.find(Patient.class, patientId);
            entityManager.getTransaction().begin();
            entityManager.remove(patient);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public Patient getById(int patientId)throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            return entityManager.find(Patient.class, patientId);
        }catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }

    public Patient getByName(String name)throws DAOException, NotFoundException{
        List<Patient> patientList;
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Patient.getByName");
            query.setParameter(1, name);
            patientList = (List<Patient>) query.getResultList();
            return patientList.get(0);
        } catch (IndexOutOfBoundsException e){
            throw new NotFoundException();
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
