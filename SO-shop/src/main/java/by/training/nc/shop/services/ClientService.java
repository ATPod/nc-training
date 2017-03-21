package by.training.nc.shop.services;

import by.training.nc.shop.entities.Client;
import by.training.nc.shop.entities.Ordering;
import by.training.nc.shop.entities.Product;
import by.training.nc.shop.exceptions.IdRepeatException;
import by.training.nc.shop.exceptions.NotFoundException;
import by.training.nc.shop.utils.DataKeeper;

import java.util.List;

public class ClientService {

    public List<Client> getAllClients(){
        return DataKeeper.clients;
    }

    public static void addClient(int id, String login, String password) throws IdRepeatException{
        for (int i = 0; i < DataKeeper.clients.size(); i++){
            if (DataKeeper.clients.get(i).getId() == id){
                throw new IdRepeatException("Repetition of ID!");
            }
        }
        DataKeeper.clients.add(new Client(id, login, password));
    }

    public static void removeClient(int idClient) throws NotFoundException{
        DataKeeper.clients.remove(findClientById(idClient));
    }

    public static Client findClientById(int idClient) throws NotFoundException{
        for (int i = 0; i < DataKeeper.clients.size(); i++){
            if (DataKeeper.clients.get(i).getId() == idClient){
                return DataKeeper.clients.get(i);
            }
        }
        throw new NotFoundException("No client with such ID");
    }

    public static void updateClientLogin(int idClient, String login) throws NotFoundException{
        Client client = findClientById(idClient);
        client.setLogin(login);
    }

    public static void updateClientPassword(int idClient, String password) throws NotFoundException{
        Client client = findClientById(idClient);
        client.setPassword(password);
    }

    public static void updateClientBlackList(int idClient, boolean inBlackList) throws NotFoundException{
        Client client = findClientById(idClient);
        client.setInBlackList(inBlackList);
    }

    public static  boolean checkBlackList(int idClient) throws NotFoundException{
        Client client = findClientById(idClient);
        return client.isInBlackList();
    }
}
