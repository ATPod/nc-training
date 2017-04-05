package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.CustomerDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlTermsOfReferenceDao
        extends MysqlAbstractDao<TermsOfReference>
        implements TermsOfReferenceDao {

    private static final String SELECT_ALL_TERMS_OF_REFERENCES_QUERY =
            "SELECT id, customer_id FROM terms_of_reference";
    private static final String SELECT_TERMS_OF_REFERENCE_BY_ID_QUERY =
            "SELECT id, customer_id FROM terms_of_reference WHERE id = ?";
    private static final String UPDATE_TERMS_OF_REFERENCE_QUERY =
            "UPDATE terms_of_reference" +
            " SET customer_id = ?" +
            " WHERE id = ?";
    private static final String DELETE_FROM_TERMS_OF_REFERENCE_QUERY =
            "DELETE FROM terms_of_reference WHERE id = ?";
    private static final String INSERT_INTO_TERMS_OF_REFERENCE_QUERY =
            "INSERT  INTO terms_of_reference(customer_id) VALUES (?)";

    protected TermsOfReference fetchEntity(ResultSet rs)
            throws SQLException, DataAccessException {

        TermsOfReference termsOfReference = new TermsOfReference();
        CustomerDao customerDao = new MysqlCustomerDao();
        int customerId = rs.getInt("customer_id");

        termsOfReference.setCustomer(customerDao.getEntityById(customerId));

        return termsOfReference;
    }

    /**
     * Gets all instances of type {@code E} that are located in data storage
     *
     * @return a collection of objects of type {@code E} located in the storage. If no
     * objects found, empty collection is returned.
     */
    public Collection<TermsOfReference> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_TERMS_OF_REFERENCES_QUERY);
    }

    /**
     * Gets a record from a storage identified by {@code id}.
     *
     * @param id a unique identifier of desired record
     * @return a record from the storage or {@code null} if no found
     */
    public TermsOfReference getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(
                id, SELECT_TERMS_OF_REFERENCE_BY_ID_QUERY);
    }

    /**
     * Updates fields of record identified by {@code entity.getId()}. Since
     * this method uses id of entity for search purpose it does not support
     * changing of this id.
     *
     * @param entity an entity to update
     * @return true if entity exists and was updated, false otherwise
     */
    public boolean update(TermsOfReference entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_TERMS_OF_REFERENCE_QUERY);

            ps.setInt(1, entity.getCustomer().getId());
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
        return delete(id, DELETE_FROM_TERMS_OF_REFERENCE_QUERY);
    }

    /**
     * Creates a new entry in the storage. Specifying id is not mandatory
     * since DAO must take care of its uniqueness within storage.
     *
     * @param entity an entity to create
     * @return an id of created entity
     */
    public Integer create(TermsOfReference entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INTO_TERMS_OF_REFERENCE_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getCustomer().getId());

            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();

            generatedKeys.next();

            return (int) generatedKeys.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }
}
