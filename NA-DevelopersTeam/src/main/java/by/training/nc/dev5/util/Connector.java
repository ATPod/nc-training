package by.training.nc.dev5.util;

import by.training.nc.dev5.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nikita on 27.03.2017.
 */
public class Connector {
    static final Logger logger = LogManager.getLogger(Connector.class);
    private static final Connector INSTANCE;

    static {
        INSTANCE = new Connector();
    }

    public static Connector getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() throws ConnectionException {
        ConfigurationManager config = new ConfigurationManager();

        logger.debug("Start reading database properties");

        String url = config.getString("database.url");
        logger.debug("Using database.url = {}", url);
        String user = config.getString("database.user");
        logger.debug("Using database.user = {}", user);
        String password = config.getString("database.password");
        String driver = config.getString("database.driver");
        logger.debug("Using database.driver = {}", driver);

        try {
            logger.info("Driver '{}' loading...", driver);
            Class.forName(driver).newInstance();
            logger.info("Driver '{}' loading SUCCESS", driver);

            logger.info("Obtaining connection ...");
            return DriverManager.getConnection(url, user, password);
        } catch (InstantiationException e) {
            logger.fatal("Driver '" + driver + "' loading FAILED", e);
            throw new ConnectionException("Failed to instantiate driver", e);
        } catch (ClassNotFoundException e) {
            logger.fatal("Driver '" + driver + "' loading FAILED", e);
            throw new ConnectionException("Driver was not loaded", e);
        } catch (IllegalAccessException e) {
            logger.fatal("Driver '" + driver + "' loading FAILED", e);
            throw new ConnectionException("Inaccessible driver class", e);
        } catch (SQLException e) {
            logger.fatal("Obtaining connection FAILED", e);
            throw new ConnectionException("Could not connect to database", e);
        }
    }
}
