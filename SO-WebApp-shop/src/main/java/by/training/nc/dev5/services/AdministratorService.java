package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.AdministratorDao;
import by.training.nc.dev5.entities.Administrator;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public class AdministratorService {

    public static AdministratorDao administratorDao = new AdministratorDao();

    public static List<Administrator> getAllAdministrators() throws DAOException{
        return administratorDao.getAll();
    }

    public static void updateAdministratorPassword(int idAdmin, String password) throws DAOException, NotFoundException {
        administratorDao.findById(idAdmin);
        administratorDao.updatePassword(idAdmin, password);
    }

    public static Administrator findAdministratorByParameters(String name, String password) throws DAOException, NotFoundException{
        return administratorDao.findByParameters(name, password);
    }
}
