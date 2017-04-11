package by.training.nc.dev5.dbmanager;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import by.training.nc.dev5.util.PropertiesUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/*
    private final static String driverClassName = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/mk-library";
    private final static String password = "1234";
    private final static String name = "root";
 */

public final class DBManager {


    private final static Logger logger = LogManager.getLogger(DBManager.class);


    private static final String MYSQL_CONFIG_PROPERTIES = "mysql.properties";
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    private static final String CONNECTION_URL = "connectionUrl";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    private static DBManager instance;
    private Connection con;

    private DBManager() {
        con = getMySQLConnection();
    }


    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    /**
     * Connection to MySQL Database
     */
    public static Connection getMySQLConnection() {

        Connection connection = null;
        try {

            Properties mySQLproperties = new PropertiesUtil().getProperties(MYSQL_CONFIG_PROPERTIES);
            Class.forName(mySQLproperties.getProperty(DRIVER_CLASS_NAME));
            connection = DriverManager.getConnection(mySQLproperties.getProperty(CONNECTION_URL),
                    mySQLproperties.getProperty(USER),
                    mySQLproperties.getProperty(PASSWORD));

            return connection;

        } catch (SQLException se) {
            logger.error(se.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

}