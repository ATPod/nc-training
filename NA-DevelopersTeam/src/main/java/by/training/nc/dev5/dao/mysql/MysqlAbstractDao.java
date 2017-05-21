package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.exception.ConnectionException;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public abstract class MysqlAbstractDao<E> implements AbstractDao<E, Integer> {
    protected Connection getConnection() throws DataAccessException {
        try {
            return Connector.getInstance().getConnection();
        } catch (ConnectionException e) {
            throw new DataAccessException("Unable to obtain connection", e);
        }
    }

    protected void disposeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // todo (logger will be enough)
        }
    }

    protected Collection<E> getAll(String sql) throws DataAccessException {
        Connection conn = getConnection();
        Collection<E> result = new ArrayList<E>();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                E e = fetchEntity(rs);

                if (e != null) {
                    result.add(e);
                }
            }

            return result;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    protected E getSingleResultByIntParameter(Integer id, String sql)
            throws DataAccessException {

        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            return fetchEntity(rs);
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    protected Collection<E> getCollectionByIntParameter(int id, String sql) throws DataAccessException {
        Collection<E> result = new ArrayList<E>();
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs;

            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                E e = fetchEntity(rs);

                if (e != null) {
                    result.add(e);
                }
            }

            return result;
        } catch (SQLException e) {
            throw new DataAccessException("Database error occurred", e);
        } finally {
            disposeConnection(conn);
        }
    }

    protected abstract E fetchEntity(ResultSet rs)
            throws DataAccessException;

    protected boolean delete (Integer id, String sql)
            throws DataAccessException {

        Connection connection;

        connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, id);

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataAccessException("Database access error occurred", e);
        } finally {
            disposeConnection(connection);
        }
    }
}
