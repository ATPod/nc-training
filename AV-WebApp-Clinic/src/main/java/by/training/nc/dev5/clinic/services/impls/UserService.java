package by.training.nc.dev5.clinic.services.impls;

import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.dao.impl.UserMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.exceptions.NotFoundException;
import by.training.nc.dev5.clinic.enums.UserType;

/**
 * Created by user on 22.04.2017.
 */
public class UserService {

    public static boolean isAuthorized(String login, String password)throws DAOException {
        try {
            return (password.equals(UserMySQLDAO.getInstance().getByLogin(login).getPassword()));
        }
        catch (NotFoundException e){
            return false;
        }
    }

    public static User getByLogin(String login)throws DAOException {
        try {
            return UserMySQLDAO.getInstance().getByLogin(login);
        }catch (NotFoundException e) {
            return null;
        }
    }

    public static UserType checkAccessLevel(String login) throws DAOException{
        try{
            if(AccessLevels.DOCTOR.equals(UserMySQLDAO.getInstance().getByLogin(login).getAccessLevel())){
                return UserType.DOCTOR;
            }else{
                return UserType.NURSE;
            }
        } catch (NotFoundException e){
            return null;
        }
    }

    public static void add(User user)throws DAOException {
        UserMySQLDAO.getInstance().add(user);
    }

    public static boolean isNewUser(String login) throws DAOException {
        try {
            UserMySQLDAO.getInstance().getByLogin(login);
            return false;
        } catch (NotFoundException e){
            return true;
        }

    }
}
