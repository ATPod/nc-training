package by.training.nc.dev5.testing.services.interfaces;

import by.training.nc.dev5.testing.services.exceptions.ServiceException;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {
    Serializable addEntity(T entity) throws ServiceException;

    T findById(int id) throws ServiceException;

    void delete(int id) throws ServiceException;

    void update(T entity) throws ServiceException;

    List<T> getAll() throws ServiceException;
}
