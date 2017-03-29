package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private static final String SQL_QUERY_INSERT       = "INSERT INTO product (title, price) VALUES(?,?)";
    private static final String SQL_QUERY_GET_ALL      = "SELECT * FROM product";
    private static final String SQL_QUERY_GET_BY_ORDERING = "SELECT product.id, product.title, product.price " +
                                                            "FROM product JOIN ordering_product ON product.id=ordering_product.idProduct " +
                                                            "WHERE ordering_product.idOrder=?";
    private static final String SQL_QUERY_FIND_BY_ID   = "SELECT * FROM product WHERE id=?";
    private static final String SQL_QUERY_UPDATE_TITLE = "UPDATE product SET title=? where id=?";
    private static final String SQL_QUERY_UPDATE_PRICE = "UPDATE product SET price=? where id=?";
    private static final String SQL_QUERY_DELETE       = "DELETE FROM product WHERE id=?";

    public void add(String title, int price) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_INSERT);
            st.setString(1, title);
            st.setInt(2, price);
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

    public List<Product> getByOrderingId(int id) throws DAOException {
        List<Product> products = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_GET_BY_ORDERING);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("price")));
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
        return products;
    }

    public List<Product> getAll() throws DAOException {
        List<Product> products = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_QUERY_GET_ALL);
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                                         resultSet.getString("title"),
                                         resultSet.getInt("price")));
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
        return products;
    }

    public void updateTitle(int id, String newTitle) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_TITLE);
            st.setString(1, newTitle);
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

    public void updatePrice(int id, int newPrice) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_PRICE);
            st.setInt(1, newPrice);
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

    public void delete(int id) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_DELETE);
            st.setInt(1, id);
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

    public Product findById(int id) throws DAOException, NotFoundException {
        Connection cn = null;
        PreparedStatement st = null;
        Product product = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_FIND_BY_ID);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                product = new Product(resultSet.getInt("id"),
                                      resultSet.getString("title"),
                                      resultSet.getInt("price"));
            }
            if (product != null){
                return product;
            }
            else {
                throw new NotFoundException("No product with this ID!");
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
