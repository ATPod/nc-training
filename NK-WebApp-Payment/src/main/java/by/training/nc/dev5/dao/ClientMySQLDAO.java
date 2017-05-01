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
import com.sun.org.apache.regexp.internal.RE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.dao.ClientDAO;

/**
 * @author nic
 * 
 */
public class ClientMySQLDAO implements ClientDAO {

	private static final String SQL_SELECT = "SELECT client_id, client_status, name, login, password from client";
	private static final String SQL_INSERT = "INSERT INTO client (" +
			"client_status, name,login,password) values(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE client SET client_status = ?,name = ?," +
			"login = ?,password =?, WHERE client.client_id = ?";
	private static final String SQL_DELETE = "DELETE FROM client WHERE client.client_id = ?";
	private static final String SQL_FIND = "SELECT * FROM client WHERE client_id = ?";
	private static final String SQL_FIND_BY_LOGOPASS = "SELECT * FROM client WHERE login = ?";

	// logger for the class
	private static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);

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

	public Person findPerson(String pLogin, String pPassword){
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_FIND_BY_LOGOPASS)) {
			ptmt.setString(1, pLogin);
			ResultSet rs = ptmt.executeQuery();
			if(rs != null){
				rs.next();
				if(rs.getString(4).equals(pPassword)) {
					Person person = new Person();
					person.setName(rs.getString("name"));
					person.setStatus(rs.getBoolean("client_status"));
					person.setId(rs.getInt("client_id"));
					person.setLogin(rs.getString("login"));
					person.setPassword(rs.getString("password"));
					return person;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				client.setLogin(rs.getString("login"));
				client.setPassword(rs.getString("password"));
				return client;
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
			if(pClient.getId() == 0) {
				ptmt.setBoolean(1, pClient.isStatus());
				ptmt.setString(2, pClient.getName());
				ptmt.setString(3, pClient.getLogin());
				ptmt.setString(4, pClient.getPassword());
				success = ptmt.executeUpdate();
			}
		}catch (SQLException ex){
			logger.error(ex.getMessage());
		}
		return success;
	}

	public Collection<Client> selectClients() {
		try {
			List<Client> clients = new ArrayList<Client>();
			Client clientBean;
			Connection connection = MySQLDAOFactory.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(SQL_SELECT);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				clientBean = new Client();
				clientBean.setId(rs.getInt(1));
				clientBean.setStatus(rs.getBoolean(2));
				clientBean.setName(rs.getString(3));
				clientBean.setLogin(rs.getString(4));
				clientBean.setPassword(rs.getString(5));
				clients.add(clientBean);
				logger.debug("Employee.id:" + clientBean.getId() +
						" Employee.Status:" + clientBean.isStatus() +
						" Employee.Name:" + clientBean.getName() );
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
			ptmt.setString(4,pClient.getLogin());
			ptmt.setString(5,pClient.getPassword());
			success = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (success > 0);
	}

}
