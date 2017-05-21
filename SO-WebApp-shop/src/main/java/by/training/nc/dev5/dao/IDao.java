package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.AbstractEntity;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;

import java.util.List;

public interface IDao <T extends AbstractEntity> {

    void add (T entity) throws DaoException;

    List <T> getAll() throws DaoException;

    void update (T entity) throws DaoException;

    void remove (T entity) throws DaoException;

    T getById(int id) throws DaoException, NotFoundException;

}
