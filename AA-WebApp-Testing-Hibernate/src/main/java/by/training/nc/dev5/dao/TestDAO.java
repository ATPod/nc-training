package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestDAO extends GenericDAO<Test> {
    public TestDAO() {

        super(Test.class);
    }

    public List<Test> getAllByName(String testName) {
        List<Test> tests = null;
        try {
            Session session = util.getSession();
            Query<Test> query = session.createQuery("from Test where name = :paramName ", Test.class);
            query.setParameter("paramName", testName);
            tests = query.getResultList();
        } catch (HibernateException e) {
            String message = "Unable to find test. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return tests;
    }

    public List<Test> getAllBySubject(String subject) {
        List<Test> tests = null;
        try {
            Session session = util.getSession();
            Query<Test> query = session.createQuery("from Test where subject = :paramSubject ", Test.class);
            query.setParameter("paramSubject", subject);
            tests = query.getResultList();
        } catch (HibernateException e) {
            String message = "Unable to find test. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return tests;
    }
}
