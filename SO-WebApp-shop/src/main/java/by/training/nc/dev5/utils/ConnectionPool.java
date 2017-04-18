package by.training.nc.dev5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;

public class ConnectionPool {

    private static ResourceBundle resource;
    private static String url;
    private static String user;
    private static String pass;

    private static Vector<Connection> availableConns;
    private static Vector<Connection> usedConns;

    static {
        resource = ResourceBundle.getBundle("database");
        url = resource.getString("url");
        user = resource.getString("user");
        pass = resource.getString("password");

        availableConns = new Vector<Connection>();
        usedConns = new Vector<Connection>();
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static synchronized Connection retrieve() throws SQLException {
        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public static synchronized void putback(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Connection not in the usedConns array");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}