package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.ClientDao;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public class ClientService {

    private static ClientDao clientDao = new ClientDao();

    public static List<Client> getAllClients() throws DAOException{
        return clientDao.getAll();
    }

    public static void addClient(String firstName, String lastName, String email, String password) throws DAOException, DuplicationException{
        try {
            clientDao.findByEmail(email);
            throw new DuplicationException();
        }
        catch (NotFoundException e){
            clientDao.add(firstName, lastName, email, password);
        }
    }

    public static Client findClientById(int clientId) throws DAOException, NotFoundException{
        return clientDao.findById(clientId);
    }

    public static void updateClientEmail(int clientId, String email) throws DAOException, NotFoundException{
        clientDao.findById(clientId);
        clientDao.updateEmail(clientId, email);
    }

    public static void updateClientPassword(int clientId, String password) throws NotFoundException, DAOException{
        clientDao.findById(clientId);
        clientDao.updatePassword(clientId, password);
    }

    public static void updateClientFirstName(int clientId, String firstName) throws NotFoundException, DAOException{
        clientDao.findById(clientId);
        clientDao.updateFirstName(clientId, firstName);
    }

    public static void updateClientLastName(int clientId, String lastName) throws NotFoundException, DAOException{
        clientDao.findById(clientId);
        clientDao.updateLastName(clientId, lastName);
    }

    public static void updateClientBlackList(int clientId, boolean inBlackList) throws NotFoundException, DAOException{
        clientDao.findById(clientId);
        if (inBlackList){
            clientDao.updateBlackList(clientId, (byte)1);
        } else {
            clientDao.updateBlackList(clientId, (byte)0);
        }
    }

    public static  boolean checkBlackList(int idClient) throws NotFoundException, DAOException{
        Client client = clientDao.findById(idClient);
        if (client.getBlacklist() == 0){
            return false;
        } else {
            return true;
        }
    }

    public static Client findClientByParameters(String login, String password) throws NotFoundException, DAOException{
        return clientDao.findByParameters(login, password);
    }
}
