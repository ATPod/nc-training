package by.training.nc.dev5.dao.impl;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.dao.IClientDao;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository("ClientDao")
@Transactional
public class ClientDao extends AbstractDao<Client> implements IClientDao {

    @Transactional(readOnly = true)
    public List<Client> getAll() throws DaoException {
        try {
            Query query = getSession().createNamedQuery("Client.findAll");
            List<Client> clientList = (List<Client>) query.getResultList();
            return clientList;
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    public void remove(Client client) throws DaoException {}

    @Transactional(readOnly = true)
    public Client getById(int id) throws DaoException, NotFoundException {
        try {
            Client client = getSession().find(Client.class, id);
            if (client != null){
                return client;
            }
            else {
                throw new NotFoundException();
            }
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Client getByEmail(String email) throws DaoException, NotFoundException {
        try {
            Query query = getSession().createNamedQuery("Client.findByEmail");
            query.setParameter(1, email);
            Client client = (Client) query.getSingleResult();
            return client;
        }
        catch (NoResultException e){
            throw new NotFoundException();
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Client getByParameters(String email, String password) throws DaoException, NotFoundException {
        try {
            Query query = getSession().createNamedQuery("Client.findByParam");
            query.setParameter(1, email);
            query.setParameter(2, password);
            Client client = (Client) query.getSingleResult();
            return client;
        }
        catch (NoResultException e){
            throw new NotFoundException();
        }
        catch (Exception e){
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            throw new DaoException(e.getMessage());
        }
    }
}
