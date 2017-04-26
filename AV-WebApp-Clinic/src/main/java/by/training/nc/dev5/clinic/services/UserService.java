package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.dao.UserMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;

/**
 * Created by user on 22.04.2017.
 */
public class UserService {

    public static boolean isAuthorized(String login, String password){
        try {
            return (password.equals(UserMySQLDAO.INSTANCE.getByLogin(login).getPassword()));
        }
        catch (NullPointerException e){
            return false;
        }
    }

    public static User getByLogin(String login) {
        return UserMySQLDAO.INSTANCE.getByLogin(login);
    }

    public static UserType checkAccessLevel(String login){
        if(AccessLevels.DOCTOR.equals(UserMySQLDAO.INSTANCE.getByLogin(login).getAccessLevel())){
            return UserType.DOCTOR;
        }else{
            return UserType.NURSE;
        }
    }

    public static void add(User user) {
        UserMySQLDAO.INSTANCE.add(user);
    }

    public static boolean isNewUser(String login) {
        return (UserMySQLDAO.INSTANCE.getByLogin(login)==null);
    }

}
