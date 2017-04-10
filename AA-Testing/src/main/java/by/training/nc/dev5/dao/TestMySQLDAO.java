package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.sql.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestMySQLDAO implements InterfaceDAO<Test> {
    @Override
    public Test find(int id) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_TEST)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setSubject(rs.getString("subject"));
                test.setName(rs.getString("name"));
                test.setAuthorId(rs.getInt("tutor_id"));
                return test;
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Test test) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_TEST)
        ) {
            statement.setInt(1, test.getId());
            statement.setString(2, test.getName());
            statement.setInt(4, test.getAuthorId());
            statement.setString(3, test.getSubject());
            InterfaceDAO<Question> questionMySQLDAO = new MySQLDAOFactory().getQuestionDAO();
            for (Question question : test.getQuestions()) {
                questionMySQLDAO.insert(question);
            }
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (modifiedRows > 0);
    }

    @Override
    public boolean update(Test entity) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_TEST);
        ) {
            statement.setString(1,entity.getName());
            statement.setString(2,entity.getSubject());
            statement.setInt(4,entity.getId());
            statement.setInt(3,entity.getAuthorId());
            modifiedRows= statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (0 < modifiedRows);
    }
    @Override
    public boolean delete(int id) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_TEST)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
                int id = rs.getInt("id");
                Test test = find(id);
                if (test != null) {
                    tests.add(test);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }

        return tests;
    }

    @Override
    public List<Test> getAll(String where,String...params) {
        return null;
    }
}
