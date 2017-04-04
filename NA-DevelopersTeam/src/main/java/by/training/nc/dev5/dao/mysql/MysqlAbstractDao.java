package by.training.nc.dev5.dao.mysql;

import by.training.nc.dev5.dao.AbstractDao;
import by.training.nc.dev5.entity.Invoice;
import by.training.nc.dev5.exception.ConnectionException;
import by.training.nc.dev5.util.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 29.03.2017.
 */
public abstract class MysqlAbstractDao<E> implements AbstractDao<E, Integer> {
    protected Connection getConnection() {
        try {
            return Connector.getInstance().getConnection();
        } catch (ConnectionException e) {
            e.printStackTrace();
//            todo
        }

        return null;
    }

    protected void disposeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        }
    }

    protected Collection<E> getAll(String sql) {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql);
            ResultSet rs = ps.executeQuery();
            Collection<E> result = new ArrayList<E>();

            while (rs.next()) {
                result.add(fetchEntity(rs));
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }

    protected E getSingleResultByIntParameter(Integer id, String sql) {
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(
                    sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return fetchEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // todo
        } finally {
            disposeConnection(conn);
        }

        return null;
    }

    protected abstract E fetchEntity(ResultSet rs) throws SQLException;

    protected boolean delete (Integer id, String sql) {
        Connection connection = getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);

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
}
