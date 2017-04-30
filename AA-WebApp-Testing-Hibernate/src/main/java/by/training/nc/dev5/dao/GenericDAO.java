package by.training.nc.dev5.dao;

import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class GenericDAO<T> implements InterfaceDAO<T> {
    protected static HibernateUtil util = HibernateUtil.getInstance();
    private Class<T> persistentClass;

    public GenericDAO(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public T find(int id) {
        T entity = null;
        try {
            Session session = util.getSession();
            entity = session.get(persistentClass, id);
        } catch (HibernateException e) {
            String message = "Unable to find " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return entity;
    }

    @Override
    public Serializable insert(T entity) {
        Serializable id = 0;
        try {
            Session session = util.getSession();
            session.saveOrUpdate(entity);
            id = session.getIdentifier(entity);
        } catch (HibernateException e) {
            String message = "Unable to update " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return id;
    }

    @Override
    public void update(T entity) {
        try {
            Session session = util.getSession();
            session.merge(entity);
        } catch (HibernateException e) {
            String message = "Unable to update " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
    }

    @Override
    public void delete(int entityId) {
        try {
            Session session = util.getSession();
            T entity = session.get(persistentClass, entityId);
            session.delete(entity);
        }
        catch(HibernateException e){
            String message = "Unable to delete " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
    }

    @Override
    public List<T> getAll() {
        List<T> results=null;
        try {
            Session session = util.getSession();
            CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
            CriteriaQuery<T> criteria=criteriaBuilder.createQuery(persistentClass);
            Root<T> typeRoot=criteria.from(persistentClass);
            criteria.select(typeRoot);
            results=session.createQuery(criteria).getResultList();
        }
        catch(HibernateException e){
            String message = "Unable to getAll " + getClass().getSimpleName();
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return results;
    }

}
