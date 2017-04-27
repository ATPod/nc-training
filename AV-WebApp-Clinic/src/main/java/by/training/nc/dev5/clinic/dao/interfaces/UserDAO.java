package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.entities.User;

/**
 * Created by user on 06.04.2017.
 */
public interface UserDAO {
    void add(User user);
    User getByLogin(String login);
}
