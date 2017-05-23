package by.training.nc.dev5.testing.services.interfaces;

import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;

public interface IUserService extends IService<User> {
    User getAuthorizedUser(String login, String password) throws ServiceException;
    User getAuthorizedUser(String login) throws ServiceException;
}
