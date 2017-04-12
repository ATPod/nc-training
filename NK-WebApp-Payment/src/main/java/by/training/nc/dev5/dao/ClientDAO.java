package by.training.nc.dev5.dao;

import java.util.Collection;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Person;


public interface ClientDAO {
	  int insertClient(Client pClient);
	  boolean deleteClient(Client pClient);
	  Client findClient(int pClientId);
	  boolean updateClient(Client pClient);
	  Collection<Person> selectClients();
}
