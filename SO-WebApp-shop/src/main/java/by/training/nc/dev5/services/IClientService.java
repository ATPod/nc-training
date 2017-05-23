package by.training.nc.dev5.services;

import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public interface IClientService {

    List<Client> getAllClients() throws DaoException;

    void addClient(String firstName, String lastName, String email, String password) throws DaoException, DuplicationException;

    Client findClientById(int clientId) throws DaoException, NotFoundException;

    void updateClientProfile(int clientId, String email, String firstName, String lastName, String password) throws DaoException, NotFoundException;

    void updateClientBlackList(int clientId, boolean inBlackList) throws NotFoundException, DaoException;

    boolean checkBlackList(int idClient) throws NotFoundException, DaoException;

    Client findClientByParameters(String login, String password) throws NotFoundException, DaoException;

}
