package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.entity.Customer;

/**
 * Created by Nikita on 27.03.2017.
 */
public class MysqlCustomerDao
        extends MysqlAbstractPersonDao<Customer>
        implements CustomerDao {

//    private static final String SELECT_ALL_CUSTOMERS_QUERY =
//            "SELECT id, name FROM customer";
//    private static final String SELECT_CUSTOMER_BY_ID_QUERY =
//            "SELECT id, name FROM customer WHERE id = ?";
//    private static final String UPDATE_CUSTOMER_QUERY =
//            "UPDATE person SET name = ? WHERE id = ?";
//    private static final String DELETE_FROM_CUSTOMER_QUERY =
//            "DELETE FROM person WHERE id = ?";
//    private static final String INSERT_INTO_CUSTOMER_QUERY =
//            "INSERT INTO person(name, role_id) VALUES (?, ?)";

    public MysqlCustomerDao() {
        super(Customer.class);
    }

//    public Collection<Customer> getAll() throws DataAccessException {
//        return getAll(SELECT_ALL_CUSTOMERS_QUERY);
//    }

//    /**
//     * Gets a record from a storage identified by {@code id}.
//     *
//     * @param id a unique identifier of desired record
//     * @return a record from the storage or {@code null} if no found
//     */
//    public Customer getEntityById(Integer id) throws DataAccessException {
//        return getSingleResultByIntParameter(id, SELECT_CUSTOMER_BY_ID_QUERY);
//    }

//    @Override
//    protected Customer fetchEntity(ResultSet rs) throws DataAccessException {
//        Customer customer = new Customer();
//
//        try {
//            customer.setId(rs.getInt("id"));
//            customer.setName(rs.getString("name"));
//        } catch (SQLException e) {
//            throw new DataAccessException("Database access error occurred", e);
//        }
//
//        return customer;
//    }

//    /**
//     * Updates fields of record identified by {@code entity.getId()}. Since
//     * this method uses id of entity for search purpose it does not support
//     * changing of this id.
//     *
//     * @param entity an entity to update
//     * @return true if entity exists and was updated, false otherwise
//     */
//    public boolean update(Customer entity) throws DataAccessException {
//        Connection connection = getConnection();
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(
//                    UPDATE_CUSTOMER_QUERY);
//
//            ps.setString(1, entity.getName());
//            ps.setInt(2, entity.getId());
//
//            return ps.executeUpdate() != 0;
//        } catch (SQLException e) {
//            throw new DataAccessException("Database error occurred", e);
//        } finally {
//            disposeConnection(connection);
//        }
//    }

//    /**
//     * Deletes entry with id
//     *
//     * @param id an identifier of entry to delete
//     * @return true if entry existed and was deleted, false otherwise
//     */
//    public boolean delete(Integer id) throws DataAccessException {
//        return delete(id, DELETE_FROM_CUSTOMER_QUERY);
//    }

//    /**
//     * Creates a new entry in the storage. Specifying id is not mandatory
//     * since DAO must take care of its uniqueness within storage.
//     *
//     * @param entity an entity to create
//     * @return an id of created entity
//     */
//    public Integer create(Customer entity) throws DataAccessException {
//        Connection connection = getConnection();
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(
//                    INSERT_INTO_CUSTOMER_QUERY,
//                    PreparedStatement.RETURN_GENERATED_KEYS);
//            ResultSet generatedKeys;
//
//            ps.setString(1, entity.getName());
//            ps.setInt(2, UserRole.CUSTOMER.getRoleId());
//
//            ps.executeUpdate();
//
//            generatedKeys = ps.getGeneratedKeys();
//            generatedKeys.next();
//
//            int id = (int) generatedKeys.getLong(1);
//
//            entity.setId(id);
//
//            return id;
//        } catch (SQLException e) {
//            throw new DataAccessException("Database error occurred", e);
//        } finally {
//            disposeConnection(connection);
//        }
//    }
}
