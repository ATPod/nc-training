package by.training.nc.dev5;


import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.sql.SQLQueries;

import java.util.List;

public class App {
    public static void main(String[] args) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> dao = factory.getUserDAO();
        List<User> users = dao.getAll(SQLQueries.FIND_BY_LOGIN_PASSWORD, "1", "1");
        System.out.println(users.get(0));
    }
}

