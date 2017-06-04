package by.training.nc.dev5.jpaservice;

import by.training.nc.dev5.entity.User;
import by.training.nc.dev5.exception.DbException;
import by.training.nc.dev5.jpa.UserJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {

    UserJPA userJPA = new UserJPA();

    public void insertUser(User user) throws DbException {

        userJPA.insertUser(user);
    }

    public void updateUser(User user) throws DbException {

        userJPA.updateUser(user);
    }

    public void deleteUser(int id) throws DbException {

        userJPA.deleteUser(id);
    }

    public User findById(int id) throws DbException {

        return userJPA.findById(id);
    }

    public User findByNameAndPassword(String name, String password) throws DbException {

        return userJPA.findByNameAndPassword(name, password);
    }

    public List<User> selectUsers() throws DbException {

        return userJPA.selectUsers();
    }
}
