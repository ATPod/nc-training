package by.training.nc.dev5.testing.dao.interfaces;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.entities.users.User;

public interface IUserDAO extends IDAO<User>{
    User getAuthorizedUser(String login, String password) throws DaoException;
    User getAuthorizedUser(String login) throws DaoException;
}
