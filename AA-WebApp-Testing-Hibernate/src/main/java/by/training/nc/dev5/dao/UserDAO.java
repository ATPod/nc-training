package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAO extends GenericDAO<User>  {

    public UserDAO() {
        super(User.class);
    }
    public boolean isAuthorized(String login, String password)
    {
      return (getAuthorizedUser(login, password)!=null);
    }
    public User getAuthorizedUser(String login, String password) {
        User user = null;
        try {
            Session session = util.getSession();
            Query query = session.createQuery("from User where login = :paramLogin " +
                    "and password =:paramPassword");
            query.setParameter("paramLogin", login);
            query.setParameter("paramPassword", password);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            String message = "Unable to find authorized  user. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
        }
        return user;
    }
}
