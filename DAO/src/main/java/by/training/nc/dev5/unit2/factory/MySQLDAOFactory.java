/**
 * 
 */
package by.training.nc.dev5.unit2.factory;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.dao.EmployeeMySQLDAO;
import by.training.nc.dev5.unit2.dao.TrainingDAO;
import by.training.nc.dev5.unit2.dao.TrainingMySQLDAO;
import by.training.nc.dev5.unit2.util.PropertiesUtil;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Andrei_Tishkovski
 * 
 */
public class MySQLDAOFactory extends DAOFactory {
	
	//Constants
	
	private static final String MYSQL_CONFIG_PROPERTIES = "mysql.properties";
	private static final String DRIVER_CLASS_NAME = "driverClassName";
	private static final String CONNECTION_URL = "connectionUrl";
	private static final String USER = "user";
	private static final String PASSWORD = "password"; 
	private static BasicDataSource mDatasource;
	
	//Members

	//Properties

	/**
	 * MySQL DAO Factory constructor
	 */
	public MySQLDAOFactory() {
		Properties mySQLproperties = new PropertiesUtil()
				.getProperties(MYSQL_CONFIG_PROPERTIES);
		mDatasource = new BasicDataSource();
		mDatasource.setDriverClassName(
				mySQLproperties.getProperty(DRIVER_CLASS_NAME));
		mDatasource.setUrl(mySQLproperties.getProperty(CONNECTION_URL));
		mDatasource.setUsername(mySQLproperties.getProperty(USER));
		mDatasource.setPassword(mySQLproperties.getProperty(PASSWORD));
		/**
		try {
			Class.forName(mySQLproperties.getProperty(DRIVER_CLASS_NAME));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
	}

	//Methods
	
	

	public static Connection getConnection() throws SQLException {
		return mDatasource.getConnection();
	}
	/**
	 * Returns factory instance
	 */
	/*
	public static synchronized DAOFactory getInstance() {
		if (daoFactory == null) {
			daoFactory = new MySQLDAOFactory();
		}
		return daoFactory;
	}*/


	public EmployeeDAO getEmpoyeeDAO() {
		return new EmployeeMySQLDAO();
	}

	public TrainingDAO getTrainingDAO() {
		return new TrainingMySQLDAO();
	}

}
