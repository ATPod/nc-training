package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

public interface IClientDao extends IDao<Client> {

    Client getByEmail(String email) throws DaoException, NotFoundException;

    Client getByParameters(String email, String password) throws DaoException, NotFoundException;

}
