package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.ManagerDao;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlManagerDao
        extends MysqlAbstractDao<Manager>
        implements ManagerDao {
    private static final String SELECT_ALL_MANAGERS_QUERY =
            "SELECT id, name FROM manager";
    private static final String SELECT_MANAGER_BY_ID_QUERY =
            "SELECT id, name FROM manager WHERE id = ?";
    private static final String UPDATE_MANAGER_QUERY =
            "UPDATE manager SET name = ? WHERE id = ?";
    private static final String DELETE_MANAGER_QUERY =
            "DELETE FROM manager WHERE id = ?";
    private static final String INSERT_INTO_MANAGER_QUERY =
            "INSERT INTO manager(name) VALUES (?)";

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Manager> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_MANAGERS_QUERY);
    }

    @Override
    protected Manager fetchEntity(ResultSet rs) throws SQLException {
        Manager manager = new Manager();

        manager.setId(rs.getInt("id"));
        manager.setName(rs.getString("name"));

        return manager;
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Manager getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_MANAGER_BY_ID_QUERY);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(Manager entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_MANAGER_QUERY);

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return false;
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) throws DataAccessException {
        return delete(id, DELETE_MANAGER_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Manager entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_MANAGER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();

            generatedKeys.next();

            int id = (int) generatedKeys.getLong(1);

            entity.setId(id);

            return id;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }
}
