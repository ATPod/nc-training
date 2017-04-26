package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.factory.DAOFactory;
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
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_TEST)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                Test test = new Test();
                test.setId(rs.getInt("id"));
                String subject = rs.getString("subject");
                test.setSubject(subject);
                String name = rs.getString("name");
                test.setName(name);
                int tutor_id = rs.getInt("tutor_id");
                test.setAuthorId(tutor_id);
                List<Question> questions = factory.getQuestionDAO().getAll(SQLQueries.FIND_TEST_QUESTIONS, id);
                InterfaceDAO<Option> optionDAO = factory.getOptionDAO();
                for (Question question : questions) {
                    question.setAnswerOptions(optionDAO.getAll(SQLQueries.FIND_QUESTION_OPTIONS, question.getId()));
                }
                test.setQuestions(questions);
                return test;
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return null;
    }

    //returns id of inserted test
    @Override
    public int insert(Test test) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement
                     (SQLQueries.INSERT_TEST, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, test.getName());
            statement.setString(2, test.getSubject());
            statement.setInt(3, test.getAuthorId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error! Test is not inserted!");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                InterfaceDAO<Question> questionDAO = factory.getQuestionDAO();
                int testId = generatedKeys.getInt(1);
                for (Question question : test.getQuestions()) {
                    question.setTestId(testId);
                    questionDAO.insert(question);
                }
                return testId;
            } else {
                throw new SQLException("Creating test failed, no ID obtained.");
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return -1;
    }

    @Override
    public boolean update(Test entity) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_TEST);
        ) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSubject());
            statement.setInt(4, entity.getId());
            statement.setInt(3, entity.getAuthorId());
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
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
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke getAll method");
        List<Test> tests = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(where)
        ) {
            int paramAmount = params.length;
            for (int i = 0; i < paramAmount; i++) {
                statement.setInt((i + 1), params[i]);
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
}
