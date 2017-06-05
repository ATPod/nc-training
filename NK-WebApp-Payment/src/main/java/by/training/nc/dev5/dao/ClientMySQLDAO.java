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

	private static final String SQL_SELECT = "SELECT F_STATUS, F_NAME, F_LOGIN, F_PASSWORD from t_person";
	private static final String SQL_INSERT = "INSERT INTO t_person (" +
			"F_STATUS, F_NAME,F_LOGIN,F_PASSWORD) values(?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE t_person SET F_STATUS = ?,F_NAME = ?," +
			"F_PASSWORD =?, WHERE t_person.F_LOGIN = ?";
	private static final String SQL_DELETE = "DELETE FROM t_person WHERE t_person.F_LOGIN = ?";
	private static final String SQL_FIND = "SELECT * FROM t_person WHERE F_LOGIN = ?";
	private static final String SQL_FIND_BY_LOGOPASS = "SELECT * FROM t_person WHERE F_LOGIN = ?";

	// logger for the class
	static Logger logger = LogManager.getLogger(ClientMySQLDAO.class);

	public ClientMySQLDAO() {}

	public boolean deleteClient(Person pPerson) {
		int success = 0;
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_DELETE)) {
			ptmt.setString(1, pPerson.getLogin());
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
					person.setName(rs.getString("F_NAME"));
					person.setStatus(rs.getBoolean("F_STATUS"));
					person.setLogin(rs.getString("F_LOGIN"));
					person.setPassword(rs.getString("F_PASSWORD"));
					return person;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Person findClient(int pClientId) {
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_FIND)) {
			ptmt.setInt(1, pClientId);
			ResultSet rs = ptmt.executeQuery();
			if(rs != null){
				rs.next();
				Client client = new Client();
				client.setLogin(rs.getString("F_LOGIN"));
				client.setName(rs.getString("F_NAME"));
				client.setStatus(rs.getBoolean("F_STATUS"));
				client.setPassword(rs.getString("F_PASSWORD"));
				return client;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertClient(Person pPerson) {
		int success = 0;
		try(Connection connection = MySQLDAOFactory.getConnection();
		PreparedStatement ptmt = connection.prepareStatement(SQL_INSERT)){
			ptmt.setBoolean(1, pPerson.isStatus());
			ptmt.setString(2, pPerson.getName());
			ptmt.setString(3, pPerson.getLogin());
			ptmt.setString(4, pPerson.getPassword());
			success = ptmt.executeUpdate();
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
				clientBean.setStatus(rs.getBoolean(1));
				clientBean.setName(rs.getString(2));
				clientBean.setLogin(rs.getString(3));
				clientBean.setPassword(rs.getString(4));
				clients.add(clientBean);
				logger.debug(" Employee.Status:" + clientBean.isStatus() +
						" Employee.Name:" + clientBean.getName() );
			}
			return clients;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
			return Collections.emptyList();
		}
	}

	public boolean updateClient(Person pPerson) {
		int success = 0;
		try (Connection connection = MySQLDAOFactory.getConnection();
			 PreparedStatement ptmt = connection.prepareStatement(SQL_UPDATE)) {
			ptmt.setBoolean(1, pPerson.isStatus());
			ptmt.setString(2, pPerson.getName());
			ptmt.setString(3,pPerson.getLogin());
			ptmt.setString(4,pPerson.getPassword());
			success = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (success > 0);
	}

}
