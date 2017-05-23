package by.training.nc.dev5.testing.dao;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.ITestDAO;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDAO extends GenericDAO<Test> implements ITestDAO{
    @Autowired
    public TestDAO(SessionFactory sessionFactory) {

        super(Test.class, sessionFactory);
    }
    @Override
    public List<Test> getAllByName(String testName) throws DaoException {
        List<Test> tests;
        try {
            Session session = getCurrentSession();
            Query<Test> query = session.createQuery("from Test where name = :paramName ", Test.class);
            query.setParameter("paramName", testName);
            tests = query.getResultList();
        } catch (HibernateException e) {
            String message = "Unable to find test. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();
        }
        return tests;
    }
    @Override
    public List<Test> getAllBySubject(String subject) throws DaoException {
        List<Test> tests;
        try {
            Session session = getCurrentSession();
            Query<Test> query = session.createQuery("from Test where subject = :paramSubject ", Test.class);
            query.setParameter("paramSubject", subject);
            tests = query.getResultList();
        } catch (HibernateException e) {
            String message = "Unable to find test. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();
        }
        return tests;
    }
}
