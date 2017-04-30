package by.training.nc.dev5.dao.factory;

import by.training.nc.dev5.dao.ClientDAO;
import by.training.nc.dev5.dao.CreditCardDAO;

/**
 * @author nic
 *
 */
public abstract class DAOFactory {
    // List of DAO types supported by the factory
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract ClientDAO getClientDAO();

    public abstract CreditCardDAO getCreditCardDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();//MySQLDAOFactory.getInstance();
            case ORACLE:
                return null;//new OracleDAOFactory();//OracleDAOFactory.getInstance();
            default:
                return null;
        }
    }
}