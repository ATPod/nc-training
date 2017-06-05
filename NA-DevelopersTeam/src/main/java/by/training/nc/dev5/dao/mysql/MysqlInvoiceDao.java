package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.InvoiceDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public class MysqlInvoiceDao
        extends MysqlAbstractDao<Invoice>
        implements InvoiceDao {

    private static final String SELECT_ALL_INVOICES_QUERY =
            "SELECT id, project_id, price, paid FROM invoice";
    private static final String SELECT_INVOICE_BY_ID_QUERY =
            "SELECT id, project_id, price, paid FROM invoice WHERE id = ?";
    private static final String UPDATE_INVOICE_QUERY =
            "UPDATE invoice" +
            " SET project_id = ?, price = ?, paid = ?" +
            " WHERE id = ?";
    private static final String DELETE_INVOICE_QUERY =
            "DELETE FROM invoice WHERE id = ?";
    private static final String INSERT_INVOICE_QUERY =
            "INSERT INTO invoice(project_id, price, paid)" +
                    " VALUES (?, ?, ?)";
    private static final String SELECT_INVOICES_BY_CUSTOMER_QUERY =
            "SELECT i.id, paid, price, project_id \n" +
                "FROM invoice i\n" +
                "JOIN project p ON i.project_id = p.id\n" +
                "JOIN terms_of_reference terms ON p.terms_of_reference_id = terms.id\n" +
                "WHERE terms.customer_id = ?";

    public Collection<Invoice> getAll() throws DataAccessException {
        return getAll(SELECT_ALL_INVOICES_QUERY);
    }

    @Override
    protected Invoice fetchEntity(ResultSet rs) throws DataAccessException {
        Invoice invoice = new Invoice();
        ProjectDao projectDao = new MysqlProjectDao();
        int projectId;

        try {
            projectId = rs.getInt("project_id");

            invoice.setId(rs.getInt("id"));
            invoice.setPrice(rs.getDouble("price"));
            invoice.setProject(projectDao.getEntityById(projectId));
            invoice.setPaid(rs.getBoolean("paid"));
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        }

        return invoice;
    }

    public Invoice getEntityById(Integer id) throws DataAccessException {
        return getSingleResultByIntParameter(id, SELECT_INVOICE_BY_ID_QUERY);
    }

    public boolean update(Invoice entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    UPDATE_INVOICE_QUERY);

            ps.setInt(1, entity.getProject().getId());
            ps.setDouble(2, entity.getPrice());
            ps.setBoolean(3, entity.isPaid());
            ps.setInt(4, entity.getId());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    public boolean delete(Integer id) throws DataAccessException {
        return delete(id, DELETE_INVOICE_QUERY);
    }

    public Integer create(Invoice entity) throws DataAccessException {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    INSERT_INVOICE_QUERY,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, entity.getProject().getId());
            ps.setDouble(2, entity.getPrice());
            ps.setBoolean(3, entity.isPaid());

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

    public Collection<Invoice> getInvoicesByCustomer(int customerId) {
        return getCollectionByIntParameter(customerId,
                SELECT_INVOICES_BY_CUSTOMER_QUERY);
    }
}
