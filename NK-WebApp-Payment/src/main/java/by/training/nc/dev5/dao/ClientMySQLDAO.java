/**
 * 
 */
package by.training.nc.dev5.dao;

import java.util.Collection;

import by.training.nc.dev5.dao.util.AbstractDAO;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.nc.dev5.entities.Client;

import java.lang.reflect.ParameterizedType;

/**
 * @author nic
 * 
 */
public class ClientMySQLDAO extends AbstractDAO<String, Person> implements ClientDAO {

	// logger for the class
	private static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);
	protected static HibernateUtil util = HibernateUtil.getInstance();
	private Class<Person> persistentClass;


	public ClientMySQLDAO() {
		super(Person.class);
	}

	public void deleteClient(Client pClient) {
		delete(pClient.getLogin());
	}

	public Person findPerson(String pLogin){
		return findByKey(pLogin);
	}

	public void insertClient(Person pPerson) {
		insert(pPerson);
	}

	public Collection<Person> selectClients() {
		return getAll();
	}

	public void updateClient(Client pClient) {
		update(pClient);
	}

}
