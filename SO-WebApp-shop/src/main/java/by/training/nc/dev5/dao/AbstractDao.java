package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.AbstractEntity;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.logger.SystemLogger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDao<T extends AbstractEntity> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void add(T entity) throws DaoException {
        try {
            getSession().persist(entity);
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    public void remove(T entity) throws DaoException {
        try {
            getSession().remove(entity);
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    public void update(T entity) throws DaoException {
        try {
            getSession().merge(entity);
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
}
