package by.training.nc.dev5.services.impl;

import by.training.nc.dev5.dao.IClientDao;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClientService")
public class ClientService implements IClientService {

    @Autowired
    @Qualifier("ClientDao")
    IClientDao clientDao;

    public List<Client> getAllClients() throws DaoException {
        return clientDao.getAll();
    }

    public void addClient(String firstName, String lastName, String email, String password) throws DaoException, DuplicationException{
        try {
            clientDao.getByEmail(email);
            throw new DuplicationException();
        }
        catch (NotFoundException e){
            Client client = new Client();
            client.setEmail(email);
            client.setFirstname(firstName);
            client.setLastname(lastName);
            client.setPassword(password);
            clientDao.add(client);
        }
    }

    public Client findClientById(int clientId) throws DaoException, NotFoundException{
        return clientDao.getById(clientId);
    }

    public void updateClientProfile(int clientId, String email, String firstName, String lastName, String password) throws DaoException, NotFoundException{
        Client client = clientDao.getById(clientId);
        if (!email.equals("")){
            client.setEmail(email);
        }

        if (!firstName.equals("")){
            client.setFirstname(firstName);
        }

        if (!lastName.equals("")){
            client.setLastname(lastName);
        }

        if (!password.equals("")){
            client.setPassword(password);
        }
        clientDao.update(client);
    }

    public void updateClientBlackList(int clientId, boolean inBlackList) throws NotFoundException, DaoException {
        Client client = clientDao.getById(clientId);
        if (inBlackList){
            client.setBlacklist((byte)1);
        } else {
            client.setBlacklist((byte)0);
        }
        clientDao.update(client);
    }

    public  boolean checkBlackList(int idClient) throws NotFoundException, DaoException {
        Client client = clientDao.getById(idClient);
        if (client.getBlacklist() == 0){
            return false;
        } else {
            return true;
        }
    }

    public Client findClientByParameters(String login, String password) throws NotFoundException, DaoException {
        return clientDao.getByParameters(login, password);
    }

    public Client findClientByEmail(String email) throws NotFoundException, DaoException {
        return clientDao.getByEmail(email);
    }
}
