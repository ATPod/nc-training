package by.training.nc.dev5.clinic.dao.impl;
import by.training.nc.dev5.clinic.dao.AbstractDAO;
import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.dao.IUserDAO;
import by.training.nc.dev5.clinic.exceptions.*;
import by.training.nc.dev5.clinic.utils.HibernateUtil;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;

public class UserMySQLDAO extends AbstractDAO<User> implements IUserDAO {
    private static UserMySQLDAO instance;

    private UserMySQLDAO(){
        super(User.class);
    }

    public User getByLogin(String login)throws DAOException, NotFoundException{
        List<User> userList;
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("User.getByLogin");
            query.setParameter(1, login);
            userList = (List<User>) query.getResultList();
            return userList.get(0);
        } catch (IndexOutOfBoundsException e){
            throw new NotFoundException();
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }

    public static synchronized UserMySQLDAO getInstance(){
        if(instance == null){
            instance = new UserMySQLDAO();
        }
        return instance;
    }
}
