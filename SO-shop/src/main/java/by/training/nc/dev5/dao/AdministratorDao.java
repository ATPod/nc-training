package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Administrator;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDao {

    private static final String SQL_QUERY_GET_ALL         = "SELECT * FROM administrator";
    private static final String SQL_QUERY_FIND_BY_ID      = "SELECT * FROM administrator WHERE id=?";
    private static final String SQL_QUERY_UPDATE_PASSWORD = "UPDATE administrator SET password=? WHERE id=?";

    public List<Administrator> getAll() throws DAOException{
        List<Administrator> administrators = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_QUERY_GET_ALL);
            while (resultSet.next()) {
                administrators.add(new Administrator(resultSet.getInt("id"),
                                                     resultSet.getString("login"),
                                                     resultSet.getString("password")));
            }
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return administrators;
    }

    public void updatePassword(int id, String newPassword) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_PASSWORD);
            st.setString(1, newPassword);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
    }

    public Administrator findById(int id) throws DAOException, NotFoundException {
        Connection cn = null;
        PreparedStatement st = null;
        Administrator administrator = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_FIND_BY_ID);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                administrator = new Administrator(resultSet.getInt("id"),
                                                  resultSet.getString("login"),
                                                  resultSet.getString("password"));
            }
            if (administrator != null){
                return administrator;
            }
            else {
                throw new NotFoundException("No administrator with this ID!");
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
    }
}
