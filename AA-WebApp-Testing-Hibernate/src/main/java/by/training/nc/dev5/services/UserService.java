package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.UserDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.utils.TransactionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService extends AbstractService<User> {
    private static UserService instance = null;
    private UserService() {
        this.dao = new UserDAO();
    }
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    public boolean checkUserAuthorization(String login, String password) {
        boolean isAuthorized = false;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            isAuthorized = ((UserDAO) dao).isAuthorized(login, password);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return isAuthorized;
    }

    public User getAuthorizedUser(String login, String password) {
        User result = null;
        Session session = util.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            result = ((UserDAO) dao).getAuthorizedUser(login, password);
            transaction.commit();
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_SUCCEEDED);
        } catch (HibernateException e) {
            TransactionUtil.rollback(transaction);
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;

    }

}
