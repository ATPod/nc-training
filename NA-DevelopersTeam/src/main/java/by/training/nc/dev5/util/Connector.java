package by.training.nc.dev5.util;

import by.training.nc.dev5.exception.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nikita on 27.03.2017.
 */
public class Connector {
    private static final Connector INSTANCE;

    static {
        INSTANCE = new Connector();
    }

    public static Connector getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws ConnectionException {
        ConfigurationManager config = ConfigurationManager.getInstance();
        String url = config.getString("database.url");
        String user = config.getString("database.user");
        String password = config.getString("database.password");
        String driver = config.getString("database.driver");

        try {
            Class.forName(driver).newInstance();

            return DriverManager.getConnection(url, user, password);
        } catch (InstantiationException e) {
            throw new ConnectionException(e);
        } catch (ClassNotFoundException e) {
            throw new ConnectionException(e);
        } catch (IllegalAccessException e) {
            throw new ConnectionException(e);
        } catch (SQLException e) {
            throw new ConnectionException(e);
        }
    }
}
