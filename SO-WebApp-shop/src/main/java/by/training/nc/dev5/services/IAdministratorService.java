package by.training.nc.dev5.services;

import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

public interface IAdministratorService {

    void updateAdministratorPassword(int adminId, String password) throws DaoException, NotFoundException;

    Administrator findAdministratorByParameters(String name, String password) throws DaoException, NotFoundException;

    Administrator findAdministratorByName(String name) throws DaoException, NotFoundException;
}
