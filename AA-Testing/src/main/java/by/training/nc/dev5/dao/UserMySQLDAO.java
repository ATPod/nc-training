package by.training.nc.dev5.dao;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.sql.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserMySQLDAO implements InterfaceDAO<User> {
    @Override
    public User find(int id) {
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
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(User user) {
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
            System.out.println(e.getMessage());
        }
        return (modifiedRows > 0);
    }

    @Override
    public boolean update(int userId) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_USER)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_ALL_USERS)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                User user = find(id);
                if (user != null) {
                    users.add(user);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
