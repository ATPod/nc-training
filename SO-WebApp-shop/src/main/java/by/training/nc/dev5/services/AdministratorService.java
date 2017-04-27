package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.AdministratorDao;
import by.training.nc.dev5.entities.Administrator;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

public class AdministratorService {

    public static AdministratorDao administratorDao = new AdministratorDao();

    public static void updateAdministratorPassword(int adminId, String password) throws DAOException, NotFoundException {
        administratorDao.findById(adminId);
        administratorDao.updatePassword(adminId, password);
    }

    public static Administrator findAdministratorByParameters(String name, String password) throws DAOException, NotFoundException{
        return administratorDao.findByParameters(name, password);
    }
}
