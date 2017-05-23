package by.training.nc.dev5.testing.dao;

import by.training.nc.dev5.testing.constants.DaoConstants;
import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IDAO;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
public class GenericDAO<T> implements IDAO<T> {
    private Class<T> persistentClass;
    @Autowired
    private SessionFactory sessionFactory;
    public GenericDAO(Class<T> persistentClass,SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory=sessionFactory;
    }
    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public T find(int id) throws DaoException{
        T entity = null;
        try {
            Session session = getCurrentSession();
            entity = session.get(persistentClass, id);
        } catch (HibernateException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), DaoConstants.ERROR_DAO +e);
            throw new DaoException();
        }
        return entity;
    }

    @Override
    public Serializable insert(T entity) throws DaoException{
        Serializable id = 0;
        try {
            Session session = getCurrentSession();
            session.saveOrUpdate(entity);
            id = session.getIdentifier(entity);
        } catch (HibernateException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), DaoConstants.ERROR_DAO + e);
            throw new DaoException();
        }
        return id;
    }

    @Override
    public void update(T entity) throws DaoException{
        try {
            Session session = getCurrentSession();
            session.merge(entity);
        } catch (HibernateException e) {
            String message = "Unable to update " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();
        }
    }

    @Override
    public void delete(int entityId) throws DaoException{
        try {
            Session session = getCurrentSession();
            T entity = session.get(persistentClass, entityId);
            session.delete(entity);
        }
        catch(HibernateException e){
            String message = "Unable to delete " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();
        }
    }

    @Override
    public List<T> getAll() throws DaoException{
        List<T> results=null;
        try {
            Session session = getCurrentSession();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<T> criteria=criteriaBuilder.createQuery(persistentClass);
            Root<T> typeRoot=criteria.from(persistentClass);
            criteria.select(typeRoot);
            results=session.createQuery(criteria).getResultList();
        }
        catch(HibernateException e){
            String message = "Unable to getAll " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();
        }
        return results;
    }

}
