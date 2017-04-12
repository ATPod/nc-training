/**
 * 
 */
package by.training.nc.dev5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.dao.ClientDAO;

/**
 * @author nic
 * 
 */
public class ClientMySQLDAO implements ClientDAO {

	private static final String SQL_SELECT = "SELECT client_id, client_status, name from client";
	private static final String SQL_INSERT = "INSERT INTO client (client_id, client_status, name) values(?,?,?)";
	private static final String SQL_UPDATE = "UPDATE client SET client_status = ?,name = ?, WHERE client.client_id = ?";
	private static final String SQL_DELETE = "DELETE FROM client WHERE client.client_id = ?";
	private static final String SQL_FIND = "SELECT * FROM client WHERE client_id = ?";
	private static final String SQL_FIND_PERSON = "SELECT * FROM client WHERE login = ?";

	// logger for the class
	static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);

	public ClientMySQLDAO() {}

	public boolean deleteClient(Client pClient) {
		int success = 0;
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_DELETE)) {
			ptmt.setInt(1, pClient.getId());
			success = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (success > 0);
	}

	public Client findClient(int pClientId) {
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_FIND)) {
			ptmt.setInt(1, pClientId);
			ResultSet rs = ptmt.executeQuery();
			if(rs != null){
				rs.next();
				Client client = new Client();
				client.setName(rs.getString("name"));
				client.setStatus(rs.getBoolean("client_status"));
				client.setId(rs.getInt("client_id"));
				return client;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Person findPerson(String login, String password) {
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_FIND_PERSON)) {
			ptmt.setString(1, login);
			ResultSet rs = ptmt.executeQuery();
			if(rs != null){
				rs.next();
				Client client = new Client();
				client.setName(rs.getString("name"));
				client.setStatus(rs.getBoolean("client_status"));
				client.setId(rs.getInt("client_id"));
				client.setPassword(rs.getString("password"));
				client.setLogin(rs.getString("login"));
				if(client.getPassword() == password) {
					return client;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertClient(Client pClient) {
		int success = 0;
		try(Connection connection = MySQLDAOFactory.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(SQL_INSERT)){
			ptmt.setInt(1,pClient.getId());
			ptmt.setBoolean(2,pClient.isStatus());
			ptmt.setString(3,pClient.getName());
			ptmt.setString(4,pClient.getLogin());
			ptmt.setString(5,pClient.getPassword());
			success = ptmt.executeUpdate();
		}catch (SQLException ex){
			logger.error(ex.getMessage());
		}
		return success;
	}

	public Collection<Person> selectClients() {
		try {
			List<Person> clients = new ArrayList<Person>();
			Client ClientBean;
			Connection connection = MySQLDAOFactory.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(SQL_SELECT);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				ClientBean = new Client();
				ClientBean.setId(rs.getInt(1));
				ClientBean.setStatus(rs.getBoolean(2));
				ClientBean.setName(rs.getString(3));
				ClientBean.setLogin(rs.getString(4));
				ClientBean.setPassword(rs.getString(5));
				clients.add(ClientBean);
				logger.debug("Employee.id:" + ClientBean.getId() +
						" Employee.Status:" + ClientBean.isStatus() +
						" Employee.Name:" + ClientBean.getName() );
			}
			return clients;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
			return Collections.emptyList();
		}
	}

	public boolean updateClient(Client pClient) {
		int success = 0;
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_UPDATE)) {
			ptmt.setBoolean(1, pClient.isStatus());
			ptmt.setString(2, pClient.getName());
			ptmt.setInt(3, pClient.getId());
			success = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (success > 0);
	}

}
