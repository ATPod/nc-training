package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlQualificationDao
        extends MysqlAbstractDao<Qualification>
        implements QualificationDao {
    private static final String SELECT_ALL_QUALIFICATIONS_QUERY =
            "SELECT id, name FROM qualification";
    private static final String SELECT_QUALIFICATION_BY_ID =
            "SELECT id, name FROM qualification WHERE id = ?";
    private static final String UPDATE_QUALIFICATION_QUERY =
            "UPDATE qualification SET name = ? WHERE id = ?";
    private static final String DELETE_FROM_QUALIFICATION_QUERY =
            "DELETE FROM qualification WHERE id = ?";
    private static final String INSERT_INTO_QUALIFICATION_QUERY =
            "INSERT INTO qualification(name) VALUES (?)";

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<Qualification> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_QUALIFICATIONS_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Qualification getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_QUALIFICATION_BY_ID);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(Qualification entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_QUALIFICATION_QUERY);

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) throws DataAccessException {
        return delete(id, DELETE_FROM_QUALIFICATION_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Qualification entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_QUALIFICATION_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();

            generatedKeys.next();

            int id = (int) generatedKeys.getLong(1);

            entity.setId(id);

            return id;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    protected Qualification fetchEntity(ResultSet rs) throws DataAccessException {
        Qualification qualification = new Qualification();

        try {
            qualification.setId(rs.getInt("id"));
            qualification.setName(rs.getString("name"));
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        }

        return qualification;
    }
}
