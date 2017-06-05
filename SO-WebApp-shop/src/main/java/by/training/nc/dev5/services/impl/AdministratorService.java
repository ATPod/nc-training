package by.training.nc.dev5.services.impl;

import by.training.nc.dev5.dao.IAdministratorDao;
import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("AdministratorService")
public class AdministratorService implements IAdministratorService {

    @Autowired
    @Qualifier("AdministratorDao")
    IAdministratorDao administratorDao;

    public void updateAdministratorPassword(int adminId, String password) throws DaoException, NotFoundException {
        Administrator administrator = administratorDao.getById(adminId);
        administrator.setPassword(password);
        administratorDao.update(administrator);
    }

    public Administrator findAdministratorByParameters(String name, String password) throws DaoException, NotFoundException{
        return administratorDao.getByParameters(name, password);
    }

    public Administrator findAdministratorByName(String name) throws DaoException, NotFoundException{
        return administratorDao.getByName(name);
    }
}
