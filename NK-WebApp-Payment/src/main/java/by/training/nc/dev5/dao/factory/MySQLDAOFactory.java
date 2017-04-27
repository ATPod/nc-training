package by.training.nc.dev5.dao.factory;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

import by.training.nc.dev5.dao.ClientDAO;
import by.training.nc.dev5.dao.CreditCardDAO;
import by.training.nc.dev5.dao.ClientMySQLDAO;
import by.training.nc.dev5.dao.CreditCardMySQLDAO;
import by.training.nc.dev5.dao.util.PropertiesUtil;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author nic
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
         setConection();
    }
    private static void setConection(){
        try {
            Properties mySQLproperties = new PropertiesUtil()
                    .getProperties(MYSQL_CONFIG_PROPERTIES);
            mDatasource = new BasicDataSource();
            mDatasource.setDriverClassName(
                    mySQLproperties.getProperty(DRIVER_CLASS_NAME));
            mDatasource.setUrl(mySQLproperties.getProperty(CONNECTION_URL));
            mDatasource.setUsername(mySQLproperties.getProperty(USER));
            mDatasource.setPassword(mySQLproperties.getProperty(PASSWORD));
            Class.forName(mySQLproperties.getProperty(DRIVER_CLASS_NAME));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Methods



    public static Connection getConnection() throws SQLException {
        if(mDatasource != null) {
            return mDatasource.getConnection();
        }
        else {
            setConection();
            return mDatasource.getConnection();
        }
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


    public ClientDAO getClientDAO() {
        return new ClientMySQLDAO();
    }

    public CreditCardDAO getCreditCardDAO() {
        return new CreditCardMySQLDAO();
    }

}
