package by.training.nc.dev5.testing.dao.interfaces;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

public interface IDAO<T> {
    T find(int id) throws DaoException;

    Serializable insert(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(int entityId) throws DaoException;

    List<T> getAll() throws DaoException;
}

