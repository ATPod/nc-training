package by.training.nc.dev5;


import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.InterfaceDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;

import java.util.List;

public class App {
    public static void main(String[] args) {
        MySQLDAOFactory mySQLDAOFactory=new MySQLDAOFactory();
        InterfaceDAO<User> userInterfaceDAO=mySQLDAOFactory.getUserDAO();
        List<User> users=userInterfaceDAO.getAll();
        System.out.println("Users:");
        for(User user:users)
        {
            System.out.println(user);
        }
    }
}

