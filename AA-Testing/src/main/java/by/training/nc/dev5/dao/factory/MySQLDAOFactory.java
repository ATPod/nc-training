package by.training.nc.dev5.dao.factory;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.utils.PropertiesUtil;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLDAOFactory extends DAOFactory {

    //Constants

    private static final String MYSQL_CONFIG_PROPERTIES = "mysql.properties";
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    private static final String CONNECTION_URL = "connectionUrl";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static BasicDataSource mDatasource;
    public MySQLDAOFactory() {
        Properties mySQLproperties = new PropertiesUtil()
                .getProperties(MYSQL_CONFIG_PROPERTIES);
        mDatasource = new BasicDataSource();
        mDatasource.setDriverClassName(
                mySQLproperties.getProperty(DRIVER_CLASS_NAME));
        mDatasource.setUrl(mySQLproperties.getProperty(CONNECTION_URL));
        mDatasource.setUsername(mySQLproperties.getProperty(USER));
        mDatasource.setPassword(mySQLproperties.getProperty(PASSWORD));
    }

    public static Connection getConnection() throws SQLException {
        return mDatasource.getConnection();
    }

    @Override
    public InterfaceDAO<User> getUserDAO() {
        return new UserMySQLDAO();
    }
    @Override
    public InterfaceDAO<Test> getTestDAO() {
        return new TestMySQLDAO();
    }

    @Override
    public InterfaceDAO<Question> getQuestionDAO() {
        return new QuestionMySQLDAO();
    }

    @Override
    public InterfaceDAO<Option> getOptionDAO() {
        return new OptionMySQLDAO();
    }
}
