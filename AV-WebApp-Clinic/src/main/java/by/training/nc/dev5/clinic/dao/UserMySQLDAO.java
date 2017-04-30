package by.training.nc.dev5.clinic.dao;
import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.dao.interfaces.UserDAO;
import by.training.nc.dev5.clinic.exceptions.*;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import javax.persistence.*;
import java.util.List;

public enum UserMySQLDAO implements UserDAO {
    INSTANCE;

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

    public void add(User user)throws DAOException{
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }
}
