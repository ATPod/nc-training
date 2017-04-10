package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.sql.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserMySQLDAO implements InterfaceDAO<User> {
    @Override
    public User find(int id) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke find method");
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_USER);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                int userType = rs.getInt("type");
                if (userType == 1) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setLogin(rs.getString("login"));
                    student.setPassword(rs.getString("password"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    student.setScores(rs.getInt("scores"));
                    return student;
                } else {
                    if (userType == 2) {
                        Tutor tutor = new Tutor();
                        tutor.setId(rs.getInt("id"));
                        tutor.setLogin(rs.getString("login"));
                        tutor.setPassword(rs.getString("password"));
                        tutor.setName(rs.getString("name"));
                        tutor.setSurname(rs.getString("surname"));
                        tutor.setSubject(rs.getString("subject"));
                        return tutor;
                    }
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(User user) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke insert method");
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_USER);
        ) {
            statement.setInt(1, user.getId());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getName());
            statement.setString(6, user.getSurname());
            if (user instanceof Student) {
                statement.setInt(2, 1);
                statement.setInt(7, ((Student) user).getScores());
                statement.setNull(8, Types.VARCHAR);
            } else {
                if (user instanceof Tutor) {
                    statement.setInt(2, 2);
                    statement.setNull(7, Types.INTEGER);
                    statement.setString(8, ((Tutor) user).getSubject());
                }
            }
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return (modifiedRows > 0);
    }

    @Override
    public boolean update(User entity) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke update method");
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_USER);
        ) {

            statement.setString(1, entity.getLogin());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getName());
            statement.setString(4, entity.getSurname());
            statement.setInt(7, entity.getId());
            if (entity instanceof Tutor) {
                statement.setNull(5, Types.INTEGER);
                statement.setString(6, ((Tutor) entity).getSubject());
            } else {
                if (entity instanceof Student) {
                    statement.setInt(5, ((Student) entity).getScores());
                    statement.setNull(6, Types.VARCHAR);
                }
            }
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public boolean delete(int id) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke delete method");
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_USER)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<User> getAll() {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke getAll method");
        List<User> users = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_ALL_USERS)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = find(rs.getInt("id"));
                if (user != null) {
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }

        return users;
    }

    @Override
    public List<User> getAll(String where, String... params) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke getAll method");
        List<User> users = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(where)
        ) {
            int paramAmount = params.length;
            for (int i = 0; i < paramAmount; i++) {
                statement.setString((i + 1), params[i]);
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = find(rs.getInt("id"));
                if (user != null) {
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }

        return users;
    }
}
