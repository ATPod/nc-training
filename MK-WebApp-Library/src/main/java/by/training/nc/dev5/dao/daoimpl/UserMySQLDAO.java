package by.training.nc.dev5.dao.daoimpl;

import by.training.nc.dev5.dao.UserDAO;
import by.training.nc.dev5.dbmanager.DBManager;
import by.training.nc.dev5.entity.jdbc.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@SuppressWarnings("Duplicates")

public class UserMySQLDAO implements UserDAO {

    private final static Logger logger = LogManager.getLogger(UserMySQLDAO.class);

    private static String insertUserQuery = "INSERT INTO  mk-library.users (id,name,password) VALUES (?,?,?)";
    private static String deleteUserQuery = "DELETE FROM  mk-library.users WHERE id = ?";
    private static String findUserQuery = "SELECT * FROM Users WHERE id = ? ";
    private static String selectUsersQuery = "SELECT (id,name) FROM Users ";
    private static String undateUserQuery = "UPDATE Users SET name =? where id = ? ";
    private static String loginUserQuery = "SELECT * FROM Users WHERE name = ? and password = ? ";


    @Override
    public boolean loginUser(String name, String password) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(loginUserQuery);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public int insertUser(User user) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(insertUserQuery);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            return user.getId();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean deleteUser(int id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(deleteUserQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public User findUser(int id) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(findUserQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            User user = new User();
            while (rs.next()) {
                String name = rs.getString(2);
                user.setId(id);
                user.setName(name);
            }
            return user;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;

    }

    @Override
    public boolean updateUser(User user) {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(undateUserQuery);
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            return (statement.executeUpdate() != 0);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public Collection<User> selectUsers() {
        try (Connection connection = DBManager.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectUsersQuery);
            ArrayList<User> users = new ArrayList<>();
            int id;
            String name;
            while (rs.next()) {
                id = rs.getInt(1);
                name = rs.getString(2);
                users.add(new User(id, name));
            }
            return users;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }


}
