package by.training.nc.dev5.dao;

import java.util.Collection;

/**
 * Represents a data access object for objects of {@link E} type identified
 * by key of {@link K} type.
 * @author Nikita Atroshenko
 */
public interface AbstractDao<E, K> {
    /**
     * Gets all instances of {@link E} type that are located in data storage
     * @return a collection of {@link E} objects located in the storage
     */
    Collection<E> getAll();

    /**
     * Gets a record from a storage identified by {@code id}.
     * @param id    a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    E getEntityById(K id);

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    boolean update(E entity);

    /**
     * Deletes entry with id
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    boolean delete(K id);

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     * @param entity an entity to create
     * @return an id of created entity
     */
    K create(E entity);
}
