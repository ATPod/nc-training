package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.dao.UserDAO;
import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.dao.interfaces.IUserDAO;
import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService extends AbstractService<User> implements IUserService{
    @Autowired
    IUserDAO userDAO;

    public UserService(IUserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getAuthorizedUser(String login, String password) throws ServiceException {
        User result = null;
        try {
            result = ((UserDAO) dao).getAuthorizedUser(login, password);
        } catch (DaoException e) {
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;

    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User getAuthorizedUser(String login) throws ServiceException {
        User result = null;
        try {
            result = ((UserDAO) dao).getAuthorizedUser(login);
        } catch (DaoException e) {
            TestingSystemLogger.INSTANCE.logInfo(getClass(), TRANSACTION_FAILED);
        }
        return result;

    }
}
