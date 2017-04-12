package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.connectionpool.ConnectionPool;
import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ColumnNames;
import by.training.nc.dev5.clinic.constants.SqlRequests;
import by.training.nc.dev5.clinic.dao.interfaces.UserDAO;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserMySQLDAO implements UserDAO {
    INSTANCE;

    public User getByLogin(String login) throws SQLException{
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
                user.setAccessLevel(result.getString(ColumnNames.USER_ACCESS_LEVEL));
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
                if(AccessLevels.DOCTOR.equals(result.getString(ColumnNames.USER_ACCESS_LEVEL))){
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

    public void add(User user) throws SQLException{
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.ADD_USER);
            st.setString(1, user.getLogin());
            st.setString(2, user.getPassword());
            st.setString(3, user.getAccessLevel());
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

}
