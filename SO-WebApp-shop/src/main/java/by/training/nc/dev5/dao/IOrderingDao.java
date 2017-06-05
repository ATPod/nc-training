package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.exceptions.DaoException;

import java.util.List;

public interface IOrderingDao extends IDao<Ordering>{

    List<Ordering> getByClient(int clientId) throws DaoException;

}
