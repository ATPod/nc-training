package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Administrator;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AdministratorDao {

    public void updatePassword(int id, String newPassword) throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Administrator administrator = entityManager.find(Administrator.class, id);
            administrator.setPassword(newPassword);
            entityManager.getTransaction().begin();
            entityManager.merge(administrator);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Administrator findById(int id) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Administrator administrator = entityManager.find(Administrator.class, id);
            if (administrator != null){
                return administrator;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Administrator findByParameters(String name, String password) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Administrator.findByParam");
            query.setParameter(1, name);
            query.setParameter(2, password);
            List<Administrator> administratorList = (List<Administrator>) query.getResultList();
            return administratorList.get(0);
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }
}
