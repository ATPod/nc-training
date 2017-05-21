package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

public interface IAdministratorDao extends IDao<Administrator> {

    Administrator getByParameters(String name, String password) throws DaoException, NotFoundException;

}
