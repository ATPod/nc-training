package by.training.nc.dev5.dao.factory;

import by.training.nc.dev5.dao.ClientDAO;
import by.training.nc.dev5.dao.CreditCardDAO;
import by.training.nc.dev5.dao.ClientDAO;
import by.training.nc.dev5.dao.CreditCardDAO;

/**
 * @author nic
 *
 */
public class OracleDAOFactory extends DAOFactory {

    private static OracleDAOFactory daoFactory = null;

    /* (non-Javadoc)
     * @see by.training.nc.dev5.unit2.factory.DAOFactory#getEmpoyeeDAO()
     */
    @Override
    public ClientDAO getEmpoyeeDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see by.training.nc.dev5.unit2.factory.DAOFactory#getTrainingDAO()
     */
    @Override
    public CreditCardDAO getTrainingDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    private OracleDAOFactory(){

    }

    public static synchronized OracleDAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new OracleDAOFactory();
        }
        return daoFactory;
    }

}