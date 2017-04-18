package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.filters.UserType;

import java.sql.SQLException;

/**
 * Created by user on 06.04.2017.
 */
public interface UserDAO {
    void add(User user) throws SQLException;

    User getByLogin(String login) throws SQLException;

    boolean isNewUser(String login) throws SQLException;

    boolean isAuthorized(String login, String password) throws SQLException;

    UserType checkAccessLevel(String login) throws SQLException;
}
