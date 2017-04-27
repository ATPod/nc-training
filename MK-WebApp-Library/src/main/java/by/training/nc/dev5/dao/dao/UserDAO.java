package by.training.nc.dev5.dao.dao;

import by.training.nc.dev5.model.User;

import java.util.Collection;


public interface UserDAO {

    boolean loginUser(String name , String password);
    int insertUser(User user);
    boolean deleteUser(int id);
    User findUser(int id);
    boolean updateUser(User user);
    Collection<User> selectUsers();
}
