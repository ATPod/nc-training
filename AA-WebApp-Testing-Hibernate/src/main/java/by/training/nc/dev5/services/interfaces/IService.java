package by.training.nc.dev5.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {
    Serializable addEntity(T entity);

    T findById(int id);

    void delete(int id);

    void update(T entity);

    List<T> getAll();
}
