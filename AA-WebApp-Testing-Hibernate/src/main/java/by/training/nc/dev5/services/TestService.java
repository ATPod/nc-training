package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.TestDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.utils.TransactionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TestService extends AbstractService<Test> {
    private TestService() {
        dao = new TestDAO();
    }

    private static TestService instance = null;

    public static TestService getInstance() {
        if (instance == null) {
            instance = new TestService();
        }
        return instance;
    }

    List<Test> getTestsByName(String testName) {
        List<Test> result = null;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = ((TestDAO) dao).getAllByName(testName);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }

    List<Test> getTestsBySubject(String subject) {
        List<Test> result = null;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = ((TestDAO) dao).getAllBySubject(subject);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }
}
