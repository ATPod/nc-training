package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.dao.UserMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;

import java.sql.SQLException;

/**
 * Created by user on 22.04.2017.
 */
public class UserService {

    public static boolean isAuthorized(String login, String password) throws SQLException {
        return UserMySQLDAO.INSTANCE.isAuthorized(login, password);
    }

    public static User getByLogin(String login) throws SQLException{
        return UserMySQLDAO.INSTANCE.getByLogin(login);
    }

    public static UserType checkAccessLevel(String login) throws SQLException{
        return UserMySQLDAO.INSTANCE.checkAccessLevel(login);
    }

    public static void add(User user) throws SQLException{
        UserMySQLDAO.INSTANCE.add(user);
    }

    public static boolean isNewUser(String login) throws SQLException{
        return UserMySQLDAO.INSTANCE.isNewUser(login);
    }

}
