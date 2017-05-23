package by.training.nc.dev5.testing.dao;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IUserDAO;
import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDAO extends GenericDAO<User>  implements IUserDAO{
    @Autowired
    public UserDAO(SessionFactory sessionFactory) {

        super(User.class,sessionFactory);
    }
    @Override
    public User getAuthorizedUser(String login, String password) throws DaoException {
        User user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery("from User where login = :paramLogin " +
                    "and password =:paramPassword");
            query.setParameter("paramLogin", login);
            query.setParameter("paramPassword", password);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            String message = "Unable to find authorized  user. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            System.out.println(message);
            throw new DaoException();
        }
        return user;
    }
    @Override
    public User getAuthorizedUser(String login) throws DaoException {
        User user = null;
        try {
            Session session = getCurrentSession();
            Query query = session.createQuery("from User where login = :paramLogin ");
            query.setParameter("paramLogin", login);
            user = (User) query.uniqueResult();
            System.out.println(user);
        } catch (HibernateException e) {
            String message = "Unable to find authorized  user. Error!";
            TestingSystemLogger.INSTANCE.logError(getClass(), message + e);
            throw new DaoException();

        }
        return user;
    }
}
