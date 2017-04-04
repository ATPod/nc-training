package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TaskQuota;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlTaskDao
        extends MysqlAbstractDao<Task>
        implements TaskDao {
    // TODO

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Task> getAll() {
        return null;
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Task getEntityById(Integer id) {
        return null;
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(Task entity) {
        return false;
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) {
        return false;
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Task entity) {
        return null;
    }

    protected Task fetchEntity(ResultSet rs) throws SQLException {
        return null;
    }

    public Collection<Task> getTasks(Integer termsOfReferenceId) {
        // todo
        return null;
    }
}
