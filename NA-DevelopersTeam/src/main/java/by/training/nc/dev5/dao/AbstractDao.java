package by.training.nc.dev5.dao;

import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public interface AbstractDao<E, K> {
    List<E> getAll();

    E getEntityById(K id);

    void update(E entity, K id);

    void delete(K id);

    K create(E entity);
}
