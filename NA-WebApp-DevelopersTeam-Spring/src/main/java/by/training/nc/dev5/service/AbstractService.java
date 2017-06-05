package by.training.nc.dev5.service;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Nikita on 24.05.2017.
 */
public interface AbstractService<E extends Serializable, K extends Serializable> {
    Collection<E> getAll();
    E getEntityById(K id);
    boolean update(E entity);
    boolean delete(K id);
    E create(E entity);
}
