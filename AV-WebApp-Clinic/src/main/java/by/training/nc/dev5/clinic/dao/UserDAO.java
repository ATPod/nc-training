package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.ConnectionPool.ConnectionPool;
import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ColumnNames;
import by.training.nc.dev5.clinic.constants.SqlRequests;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum  UserDAO implements AbstractDAO<User> {
    INSTANCE;

    public List<User> findAll() throws SQLException {
        //Connection connection = ConnectionPool.INSTANCE.getConnection();
        //PreparedStatement statement = connection.prepareStatement(SqlRequests.GET_ALL_CLIENTS);
        //ResultSet result = statement.executeQuery();
        List<User> list = new ArrayList<User>();
        /*while(result.next()){
            User user = new User();
            user.setFirstName(result.getString(ColumnNames.USER_FIRST_NAME));
            user.setLastName(result.getString(ColumnNames.USER_LAST_NAME));
            list.add(user);
        }
        ConnectionPool.INSTANCE.releaseConnection(connection);*/
        return list;
    }

    public User getUserByLogin(String login) throws SQLException{
        User user = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.GET_USER_BY_LOGIN);
            st.setString(1, login);
            ResultSet result = st.executeQuery();
            while(result.next()){
                user = new User();
                user.setId(result.getInt(ColumnNames.USER_ID));
                user.setLogin(result.getString(ColumnNames.USER_LOGIN));
                user.setPassword(result.getString(ColumnNames.USER_PASSWORD));
                user.setAccessLevel(result.getInt(ColumnNames.USER_ACCESS_LEVEL));
            }
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return user;
    }

    public boolean isNewUser(String login) throws SQLException{
        boolean isNew = true;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.CHECK_LOGIN);
            st.setString(1, login);
            ResultSet result = st.executeQuery();
            if(result.next()){
                isNew = false;
            }
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return isNew;
    }

    public boolean isAuthorized(String login, String password) throws SQLException{

        boolean isLogIn = false;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.CHECK_AUTHORIZATION);
            st.setString(1, login);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            if(result.next()){
                isLogIn = true;
            }
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return isLogIn;
    }

    public UserType checkAccessLevel(String login) throws SQLException{
        UserType userType = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.CHECK_ACCESS_LEVEL);
            st.setString(1, login);
            ResultSet result = st.executeQuery();
            while(result.next()){
                if(AccessLevels.DOCTOR == result.getInt("access_level")){
                    userType = UserType.DOCTOR;
                }
                else{
                    userType = UserType.NURSE;
                }
            }
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return userType;
    }

    public void createEntity(User user) throws SQLException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.ADD_USER);
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setInt(3, user.getAccessLevel());
            st.executeUpdate();
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
    }

    public User getEntityById(int id) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
