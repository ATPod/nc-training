package by.training.nc.dev5.dao;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface AbstractDao<E, K> {
    Collection<E> getAll();
    E getEntityById(K id);
    boolean update(E entity);
    boolean delete(K id);
    K create(E entity);
}
