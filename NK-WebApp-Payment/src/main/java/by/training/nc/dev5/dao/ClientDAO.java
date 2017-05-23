package by.training.nc.dev5.dao;

import java.util.Collection;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Person;


public interface ClientDAO {
	  void insertClient(Person pPerson);
	  void deleteClient(Client pClient);
	  void updateClient(Client pClient);
	  Collection<Person> selectClients();
}
