package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.constants.ServiceConstants;
import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IDAO;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class AbstractService<T> implements IService<T> {
    final String TRANSACTION_SUCCEEDED = "Transaction succeeded";
    final String TRANSACTION_FAILED = "Error was thrown in service";
    protected IDAO<T> dao;
    @Autowired
    protected TransactionTemplate transactionTemplate;
    protected AbstractService(IDAO<T> dao){
        this.dao = dao;
    }
    @Override
    public Serializable addEntity(final T entity) throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<Serializable>() {
            @Override
            public Serializable doInTransaction(TransactionStatus transactionStatus) {
                Serializable id = null;
                try {
                    id = dao.insert(entity);
                    TestingSystemLogger.INSTANCE.logInfo(AbstractService.class, ServiceConstants.TRANSACTION_SUCCEEDED);
                    TestingSystemLogger.INSTANCE.logInfo(AbstractService.class, entity.toString());
                } catch (DaoException e) {
                    TestingSystemLogger.INSTANCE.logError(AbstractService.class, ServiceConstants.TRANSACTION_FAILED);
                    transactionStatus.setRollbackOnly();
                }
                return id;
            }
        });
    }

    @Override
    public T findById(final int id) throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<T>() {
            @Override
            public T doInTransaction(TransactionStatus transactionStatus) {
                T entity = null;
                try {
                    entity = dao.find(id);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), ServiceConstants.TRANSACTION_SUCCEEDED);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), entity.toString());
                } catch (DaoException e) {
                    TestingSystemLogger.INSTANCE.logError(getClass(), ServiceConstants.TRANSACTION_FAILED + e);
                    transactionStatus.setRollbackOnly();
                }
                return entity;
            }
        });

    }

    @Override
    public void delete(final int id) throws ServiceException {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    dao.delete(id);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), ServiceConstants.TRANSACTION_SUCCEEDED);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), ServiceConstants.MESSAGE_DELETE + id);
                } catch (DaoException e) {
                    TestingSystemLogger.INSTANCE.logError(getClass(), ServiceConstants.TRANSACTION_FAILED + e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }

    @Override
    public void update(final T entity) throws ServiceException {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    dao.update(entity);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), ServiceConstants.TRANSACTION_SUCCEEDED);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), entity.toString());
                } catch (DaoException e) {
                    TestingSystemLogger.INSTANCE.logError(getClass(), ServiceConstants.TRANSACTION_FAILED + e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }

    @Override
    public List<T> getAll() throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<List<T>>() {
            @Override
            public List<T> doInTransaction(TransactionStatus transactionStatus) {
                List<T> list = new ArrayList<>();
                try {
                    list = dao.getAll();
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), ServiceConstants.TRANSACTION_SUCCEEDED);
                    TestingSystemLogger.INSTANCE.logInfo(getClass(), list.toString());
                } catch (DaoException e) {
                    TestingSystemLogger.INSTANCE.logError(getClass(), ServiceConstants.TRANSACTION_FAILED + e);
                    transactionStatus.setRollbackOnly();
                }
                return list;
            }
        });
    }
}
