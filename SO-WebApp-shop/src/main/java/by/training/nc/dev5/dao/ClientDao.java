package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClientDao {

    public void add(String firstName, String lastName, String email, String password) throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = new Client();
            client.setFirstname(firstName);
            client.setLastname(lastName);
            client.setEmail(email);
            client.setPassword(password);
            entityManager.getTransaction().begin();
            entityManager.persist(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Client findById(int id) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            if (client != null){
                return client;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public List<Client> getAll() throws DAOException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Client.findAll");
            List<Client> clientList = (List<Client>) query.getResultList();
            return clientList;
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updateFirstName(int id, String newFirstName) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            client.setFirstname(newFirstName);
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updateLastName(int id, String newLastName) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            client.setLastname(newLastName);
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updateEmail(int id, String newEmail) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            client.setEmail(newEmail);
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updatePassword(int id, String newPassword) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            client.setPassword(newPassword);
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public void updateBlackList(int id, byte newState) throws DAOException{
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Client client = entityManager.find(Client.class, id);
            client.setBlacklist(newState);
            entityManager.getTransaction().begin();
            entityManager.merge(client);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Client findByEmail(String email) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Client.findByEmail");
            query.setParameter(1, email);
            List<Client> clientList = (List<Client>) query.getResultList();
            return clientList.get(0);
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }

    public Client findByParameters(String email, String password) throws DAOException, NotFoundException {
        try {
            EntityManager entityManager = HibernateUtil.getEntityManager();
            Query query = entityManager.createNamedQuery("Client.findByParam");
            query.setParameter(1, email);
            query.setParameter(2, password);
            List<Client> clientList = (List<Client>) query.getResultList();
            return clientList.get(0);
        }
        catch (Exception ex){
            throw new DAOException(ex.getMessage());
        }
    }
}
