package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 27.03.2017.
 */
public abstract class MysqlCustomerDao implements CustomerDao {
    private static String SELECT_ALL_CUSTOMERS_QUERY =
            "SELECT id, name FROM customer";
    private static String SELECT_CUSTOMER_BY_ID_QUERY =
            "SELECT name FROM customer WHERE id = ?";
    private static String UPDATE_CUSTOMER_QUERY =
            "UPDATE customer SET name = ? WHERE id = ?";
    private static final String DELETE_FROM_CUSTOMER_QUERY =
            "DELETE FROM customer WHERE id = ?";
    private static final String INSERT_INTO_CUSTOMER_QUERY =
            "INSERT INTO customer(name) VALUES (?)";

    protected abstract Connection getConnection();

    protected abstract void disposeConnection(Connection connection);

    public Collection<Customer> getAll() {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    SELECT_ALL_CUSTOMERS_QUERY);
            ResultSet rs = ps.executeQuery();
            Collection<Customer> result = new ArrayList<Customer>();

            while (rs.next()) {
                Customer c = new Customer();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));

                result.add(c);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeConnection(connection);
        }
        // TODO: proper exception handling
        return null;
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public Customer getEntityById(Integer id) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    SELECT_CUSTOMER_BY_ID_QUERY);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer c = new Customer();

                c.setId(id);
                c.setName(rs.getString("name"));

                return c;
            }

            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(connection);
        }

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
    public boolean update(Customer entity) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    UPDATE_CUSTOMER_QUERY);

            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getId());

            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(connection);
        }

        return false;
    }

    /**
     * Deletes entry with id
     *
     * @param id an identifier of entry to delete
     * @return true if entry existed and was deleted, false otherwise
     */
    public boolean delete(Integer id) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    DELETE_FROM_CUSTOMER_QUERY);

            ps.setInt(1, id);

            if (ps.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(connection);
        }

        return false;
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(Customer entity) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(
                    INSERT_INTO_CUSTOMER_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, entity.getName());

            if (ps.executeUpdate() == 0) {
                return null;
            }

            ResultSet generatedKeys = ps.getGeneratedKeys();

            if (generatedKeys.next()) {
                return (int) generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(connection);
        }

        return null;
    }
}
