package by.training.nc.dev5.daoService;

import by.training.nc.dev5.dao.UserMySQLDAO;
import by.training.nc.dev5.dao.dao.UserDAO;
import by.training.nc.dev5.model.User;

import java.util.Collection;

/**
 * Created by ASUS on 19.04.2017.
 */
public class UserService {

    UserDAO ud = new UserMySQLDAO();

    public boolean loginUser(String name, String password){

        return ud.loginUser(name, password);
    }

    public int insertUser(User pUser) {
        return 0;
    }

    public boolean deleteUser(int id) {
        return false;
    }

    public User findUser(int id) {
        return null;
    }

    public boolean updateUser(User user) {
        return false;
    }

    public Collection<User> selectUsers() {
        return null;
    }


}
