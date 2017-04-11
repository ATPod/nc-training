package by.training.nc.dev5.connection;

import by.training.nc.dev5.logger.TestingSystemLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * This class describes entity <b>ConnectionPool</b>
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public class ConnectionPool {
    private String connectionUrl;
    //available connections (Vector is synchronized)
    private Vector<Connection> availableConnections = new Vector<Connection>();
    //connections which are used at this moment in time
    private Vector<Connection> usedConnections = new Vector<Connection>();

    public ConnectionPool(String url, String driver, int initialSize) {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        this.connectionUrl = url;
        for (int i = 0; i < initialSize; i++) {
            availableConnections.addElement(getConnection());
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return conn;
    }

    public synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConnections.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConnections.lastElement();
            availableConnections.removeElement(newConn);
        }
        usedConnections.addElement(newConn);
        return newConn;
    }

    public synchronized void giveBack(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConnections.removeElement(c)) {
                availableConnections.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the used connections!");
            }
        }
    }

}
