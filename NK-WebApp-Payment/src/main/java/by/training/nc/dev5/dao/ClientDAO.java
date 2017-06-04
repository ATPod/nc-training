package by.training.nc.dev5.dao;

import java.util.Collection;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Person;


public interface ClientDAO {
	  int insertClient(Person pPerson);
	  boolean deleteClient(Person pPerson);
	  Person findClient(int pClientId);
	  boolean updateClient(Person pPerson);
	  Collection<Client> selectClients();
}
