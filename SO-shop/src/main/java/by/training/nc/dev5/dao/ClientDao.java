package by.training.nc.dev5.dao;

import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private static final String SQL_QUERY_INSERT           = "INSERT INTO client (login, password, blacklist) VALUES(?,?,0)";
    private static final String SQL_QUERY_GET_ALL          = "SELECT * FROM client";
    private static final String SQL_QUERY_FIND_BY_ID       = "SELECT * FROM client WHERE id=?";
    private static final String SQL_QUERY_UPDATE_LOGIN     = "UPDATE client SET login=? where id=?";
    private static final String SQL_QUERY_UPDATE_PASSWORD  = "UPDATE client SET password=? where id=?";
    private static final String SQL_QUERY_UPDATE_BLACKLIST = "UPDATE client SET blacklist=? where id=?";
    private static final String SQL_QUERY_DELETE           = "DELETE FROM client WHERE id=?";

    public void add(String login, String password) throws DAOException {
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_INSERT);
            st.setString(1, login);
            st.setString(2, password);
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

    public List<Client> getAll() throws DAOException {
        List<Client> clients = new ArrayList<>();
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_QUERY_GET_ALL);
            while (resultSet.next()) {
                clients.add(new Client(resultSet.getInt("id"),
                                       resultSet.getString("login"),
                                       resultSet.getString("password")));
                clients.get(clients.size() - 1).setInBlackList(resultSet.getBoolean("blacklist"));
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
        return clients;
    }

    public void updateLogin(int id, String newLogin) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_LOGIN);
            st.setString(1, newLogin);
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

    public void updatePassword(int id, String newPassword) throws DAOException{
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

    public void updateBlackList(int id, boolean newCond) throws DAOException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_UPDATE_BLACKLIST);
            st.setBoolean(1, newCond);
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

    public Client findById(int id) throws DAOException, NotFoundException {
        Connection cn = null;
        PreparedStatement st = null;
        Client client = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_FIND_BY_ID);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                client = new Client(resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password"));
                client.setInBlackList(resultSet.getBoolean("blacklist"));
            }
            if (client != null){
                return client;
            }
            else {
                throw new NotFoundException("No client with this ID!");
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
}
