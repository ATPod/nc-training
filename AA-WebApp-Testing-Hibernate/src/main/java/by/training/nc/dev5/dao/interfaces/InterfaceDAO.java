package by.training.nc.dev5.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDAO<T> {
    T find(int id);

    Serializable insert(T entity);

    void update(T entity);

    void delete(int entityId);

    List<T> getAll();
}

