package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBManager {

    private final static String password = "1234";
    private final static String name = "root";
    private final static String URL = "jdbc:mysql://localhost:3306/mydb";



    private static DBManager instance ;
    private Connection con ;

    private DBManager() {
        con = getMySQLConnection();
    }

    //Thread safe instatiate method
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
            Class.forName("com.mysql.jdbc.Driver"); //.newInstance();
            connection = DriverManager.getConnection(URL,name,password);;

        } catch (SQLException se) {
            System.out.println(se);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}