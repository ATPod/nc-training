package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.sql.SQLQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestMySQLDAO implements InterfaceDAO<Test> {
    @Override
    public Test find(int id) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke find method");

        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_TEST)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setName(rs.getString("name"));
                test.setSubject(rs.getString("subject"));
                test.setAuthorId(rs.getInt("tutor_id"));
                return test;
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Test test) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke insert method");
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_TEST)
        ) {
            statement.setInt(1, test.getId());
            statement.setString(2, test.getName());
            statement.setString(3, test.getSubject());
            statement.setInt(4, test.getAuthorId());
            InterfaceDAO<Question> questionMySQLDAO = new MySQLDAOFactory().getQuestionDAO();
            for (Question question : test.getQuestions()) {
                questionMySQLDAO.insert(question);
            }
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return (modifiedRows > 0);
    }

    @Override
    public boolean update(Test entity) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke update method");
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_TEST);
        ) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSubject());
            statement.setInt(3, entity.getAuthorId());
            statement.setInt(4, entity.getId());
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
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_TEST)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<Test> getAll() {
        List<Test> tests = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_ALL_TESTS)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Test test = find(rs.getInt("id"));
                if (test != null) {
                    tests.add(test);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }

        return tests;
    }

    @Override
    public List<Test> getAll(String where, String... params) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke getAll method");
        List<Test> tests = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(where)
        ) {
            int paramAmount = params.length;
            for (int i = 0; i < paramAmount; i++) {
                statement.setString((i + 1), params[i]);
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Test test = find(rs.getInt("id"));
                if (test != null) {
                    tests.add(test);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }

        return tests;
    }

    @Override
    public List<Test> getAll(String where, Integer... params) {
        return null;
    }
}
