package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by F1 on 05.04.2017.
 */
public class AuthenticationService {
    /*
     * Basic functionality, will implement dynamic role resolving soon
     */

    private static final AuthenticationService INSTANCE
            = new AuthenticationService();
    private final DaoFactory daoFactory =
            DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public Customer logCustomerOn(String login, String password) {
        try {
            int id = Integer.parseInt(login);
            CustomerDao customerDao = daoFactory.getCustomerDao();

            return customerDao.getEntityById(id);
        } catch (NumberFormatException e) {
            return null;
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
            return null;
        }
    }

    public Manager logManagerOn(String login, String password) {
        try {
            int id = Integer.parseInt(login);
            ManagerDao managerDao = daoFactory.getManagerDao();

            return managerDao.getEntityById(id);
        } catch (NumberFormatException e) {
            return null;
        } catch (DataAccessException e) {
            e.printStackTrace();
            // todo
            return null;
        }
    }

    public static AuthenticationService getInstance() {
        return INSTANCE;
    }
}
