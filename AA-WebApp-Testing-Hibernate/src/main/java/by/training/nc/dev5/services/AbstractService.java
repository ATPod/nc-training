package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.GenericDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.services.interfaces.IService;
import by.training.nc.dev5.utils.HibernateUtil;
import by.training.nc.dev5.utils.TransactionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

abstract class AbstractService<T> implements IService<T> {
    protected static HibernateUtil util = HibernateUtil.getInstance();
    final String TRANSACTION_SUCCEEDED = "Transaction succeeded";
    final String TRANSACTION_FAILED = "Error was thrown in service";
    protected GenericDAO<T> dao;

    @Override
    public Serializable addEntity(T entity) {
        Session session = util.getSession();
        Transaction transaction = null;
        Serializable result = 0;
        try {
            transaction = session.beginTransaction();
            result = dao.insert(entity);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logError(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }

    @Override
    public T findById(int id) {
        Session session = util.getSession();
        Transaction transaction = null;
        T entity = null;
        try {
            transaction = session.beginTransaction();
            entity = dao.find(id);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logError(getClass(), TRANSACTION_FAILED);
        }
        return entity;
    }

    @Override
    public void delete(int id) {
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dao.delete(id);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logError(getClass(), TRANSACTION_FAILED);
        }
    }

    @Override
    public void update(T entity) {
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            dao.update(entity);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logError(getClass(), TRANSACTION_FAILED);
        }

    }

    @Override
    public List<T> getAll() {
        List<T> result = null;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = dao.getAll();
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logError(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }
}
