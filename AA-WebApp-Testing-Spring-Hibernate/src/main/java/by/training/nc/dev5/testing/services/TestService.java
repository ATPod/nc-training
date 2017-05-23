package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.dao.TestDAO;
import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.ITestDAO;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import by.training.nc.dev5.testing.services.interfaces.ITestService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService extends AbstractService<Test> implements ITestService {
    @Autowired
    ITestDAO testDAO;

    public TestService(ITestDAO testDAO) {
        super(testDAO);
        this.testDAO = testDAO;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Test> getTestsByName(String testName) throws DaoException {
        List<Test> result = null;
        try {
            result = ((TestDAO) dao).getAllByName(testName);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Test> getTestsBySubject(String subject) throws DaoException {
        List<Test> result = null;
        try {
            result = ((TestDAO) dao).getAllBySubject(subject);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;
    }
}
