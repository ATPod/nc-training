package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlTaskDao
        extends MysqlAbstractDao<Task>
        implements TaskDao {
    private static final String SELECT_ALL_TASKS_QUERY =
            "SELECT id, terms_of_reference_id, specification FROM task";
    private static final String SELECT_TASK_BY_ID_QUERY =
            "SELECT id, terms_of_reference_id, specification FROM task" +
            " WHERE id = ?";
    private static final String UPDATE_TASK_QUERY =
            "UPDATE task SET" +
            " terms_of_reference_id = ?," +
            " specification = ?" +
            " WHERE id = ?";
    private static final String DELETE_FROM_TASK_QUERY =
            "DELETE FROM task WHERE id = ?";
    private static final String INSERT_INTO_TASK_QUERY =
            "INSERT INTO task(terms_of_reference_id, specification)" +
            " VALUES (?, ?)";
    private static final String SELECT_TASKS_BY_TERMS_OF_REFERENCE =
            "SELECT id, specification, terms_of_reference_id FROM task" +
            " WHERE terms_of_reference_id = ?";

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Task> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_TASKS_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Task getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_TASK_BY_ID_QUERY);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(Task entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_TASK_QUERY);

            ps.setInt(1, entity.getTermsOfReference().getId());
            ps.setString(2, entity.getSpecification());
            ps.setInt(3, entity.getId());

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
        return delete(id, DELETE_FROM_TASK_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Task entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_TASK_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getTermsOfReference().getId());
            ps.setString(2, entity.getSpecification());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int id;

            generatedKeys.next();
            id = (int) generatedKeys.getLong(1);
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

    protected Task fetchEntity(ResultSet rs) throws SQLException, DataAccessException {
        Task task = new Task();
        TermsOfReferenceDao torDao = new MysqlTermsOfReferenceDao();

        task.setId(rs.getInt("id"));
        task.setSpecification("specification");
        task.setTermsOfReference(
                torDao.getEntityById(rs.getInt("terms_of_reference_id")));

        return task;
    }

    public Collection<Task> getTasks(Integer termsOfReferenceId)
            throws DataAccessException {

        return getCollectionByIntParameter(
                termsOfReferenceId, SELECT_TASKS_BY_TERMS_OF_REFERENCE);
    }
}
