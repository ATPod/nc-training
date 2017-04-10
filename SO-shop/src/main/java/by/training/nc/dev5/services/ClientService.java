package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.ClientDao;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public class ClientService {

    private static ClientDao clientDao = new ClientDao();

    public List<Client> getAllClients() throws DAOException{
        return clientDao.getAll();
    }

    public static void addClient(String login, String password) throws DAOException{
        clientDao.add(login, password);
    }

    public static void removeClient(int idClient) throws DAOException, NotFoundException{
        clientDao.findById(idClient);
        clientDao.delete(idClient);
    }

    public static void updateClientLogin(int idClient, String login) throws DAOException, NotFoundException{
        clientDao.findById(idClient);
        clientDao.updateLogin(idClient, login);
    }

    public static void updateClientPassword(int idClient, String password) throws NotFoundException, DAOException{
        clientDao.findById(idClient);
        clientDao.updateLogin(idClient, password);
    }

    public static void updateClientBlackList(int idClient, boolean inBlackList) throws NotFoundException, DAOException{
        clientDao.findById(idClient);
        clientDao.updateBlackList(idClient, inBlackList);
    }

    public static  boolean checkBlackList(int idClient) throws NotFoundException, DAOException{
        Client client = clientDao.findById(idClient);
        return client.isInBlackList();
    }

    /*public static int findClientByParameters(String login, String password){

    }*/
}
