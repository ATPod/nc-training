package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by F1 on 08.04.2017.
 */
public abstract class MysqlAbstractPersonDao<T extends Person>
        extends MysqlAbstractDao<T> {
    private static final String SELECT_ALL_PERSONS_QUERY =
            "SELECT id, name, login, password, role_id FROM person";
    private static final String SELECT_PERSON_BY_ID_QUERY =
            "SELECT id, name, login, password, role_id FROM person WHERE id = ?";
    private static final String DELETE_FROM_PERSON_QUERY =
            "DELETE FROM person WHERE id = ?";
    private static final String INSERT_INTO_PERSON_QUERY =
            "INSERT INTO person(name, login, password, role_id) " +
                    "VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PERSON_QUERY =
            "UPDATE person SET" +
                    " name = ?" +
                    " WHERE id = ?";
    private Class<T> tClass;

    protected MysqlAbstractPersonDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     * @throws DataAccessException when database access error occurs
     */
    public Collection<T> getAll() throws DataAccessException {
        Collection<T> all = getAll(SELECT_ALL_PERSONS_QUERY);

        all.remove(null);

        return all;
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     * @throws DataAccessException when database access error occurs
     */
    public T getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_PERSON_BY_ID_QUERY);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     * @throws DataAccessException when database access error occurs
     */
    public boolean update(T entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_PERSON_QUERY);

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred");
        } finally {
            disposeConnection(conn);
        }
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     * @throws DataAccessException when database access error occurs
     */
    public boolean delete(Integer id) throws DataAccessException {
        return delete(id, DELETE_FROM_PERSON_QUERY);
    }

    protected T fetchEntity(ResultSet rs) throws DataAccessException {
        int roleId;
        Person person;

        try {
            roleId = rs.getInt("role_id");
            UserRole role = UserRole.parseInt(roleId);

            switch (role) {
            case CUSTOMER:
                person = new Customer();
                break;
            case MANAGER:
                person = new Manager();
                break;
            case DEVELOPER:
                person = new Developer();
                break;
            default:
                return null;
            }

            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLogin(rs.getString("login"));
            person.setPassword(rs.getString("password"));

            if (tClass.isInstance(person)) {
                return tClass.cast(person);
            }
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred");
        }

        return null;
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     * @throws DataAccessException when database access error occurs
     */
    public Integer create(T entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_PERSON_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getLogin());
            ps.setString(3, entity.getPassword());
            ps.setInt(4, entity.getUserRole().getRoleId());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            int id;

            generatedKeys.next();
            id = (int) generatedKeys.getLong(1);
            entity.setId(id);

            return id;
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }
}
