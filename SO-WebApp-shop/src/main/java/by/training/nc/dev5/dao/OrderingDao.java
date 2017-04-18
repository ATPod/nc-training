package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderingDao {

    private static final String SQL_QUERY_INSERT          = "INSERT INTO ordering (idClient) VALUES(?)";
    private static final String SQL_QUERY_INSERT_PRODUCTS = "INSERT INTO ordering_product (idOrdering, idProduct) VALUES(?,?)";
    private static final String SQL_SELECT_LAST_ID        = "SELECT LAST_INSERT_ID()";
    private static final String SQL_QUERY_FIND_BY_ID      = "SELECT * FROM ordering WHERE id=?";
    private static final String SQL_QUERY_GET_ALL         = "SELECT * FROM ordering";
    private static final String SQL_QUERY_GET_BY_CLIENT   = "SELECT * FROM ordering WHERE idClient=?";
    private static final String SQL_QUERY_UPDATE_PAYMENT  = "UPDATE ordering SET paid=? where id=?";

    public void add(int idClient, int [] products) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_INSERT);
            st.setInt(1, idClient);
            st.executeUpdate();

            st = cn.prepareStatement(SQL_SELECT_LAST_ID);
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            int idOrder = resultSet.getInt("LAST_INSERT_ID()");

            st = cn.prepareStatement(SQL_QUERY_INSERT_PRODUCTS);
            for (int i = 0; i < products.length; i++){
                st.setInt(1, idOrder);
                st.setInt(2, products[i]);
                st.executeUpdate();
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

    public static Ordering findById(int id) throws NotFoundException, DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        Ordering ordering = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_FIND_BY_ID);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                ordering = new Ordering(resultSet.getInt("id"),
                                        resultSet.getInt("idClient"));
                ordering.setProducts(new ProductDao().getByOrderingId(id));
            }
            if (ordering != null){
                return ordering;
            }
            else {
                throw new NotFoundException("No ordering with this ID!");
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

    public static void updatePayment(int id) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_PAYMENT);
            st.setBoolean(1, true);
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

    public static List<Ordering> getAll() throws DAOException{
        List<Ordering> orderings = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_QUERY_GET_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                orderings.add(new Ordering(id, resultSet.getInt("idClient")));
                orderings.get(orderings.size() - 1).setProducts(new ProductDao().getByOrderingId(id));
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
        return orderings;
    }

    public static List<Ordering> getByClientId(int idClient) throws DAOException{
        List<Ordering> orderings = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_GET_BY_CLIENT);
            st.setInt(1, idClient);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                orderings.add(new Ordering(id,
                        resultSet.getInt("idClient")));
                orderings.get(orderings.size() - 1).setProducts(new ProductDao().getByOrderingId(id));
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
        return orderings;
    }

}
