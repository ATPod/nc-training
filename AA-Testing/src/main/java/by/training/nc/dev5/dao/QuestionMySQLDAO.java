package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
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


public class QuestionMySQLDAO implements InterfaceDAO<Question> {
    @Override
    public Question find(int id) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_QUESTION)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setScores(rs.getInt("scores"));
                question.setText(rs.getString("text"));
                question.setTestId(rs.getInt("fk_test"));
                return question;
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return null;
    }

    @Override
    public boolean insert(Question question) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_QUESTION)
        ) {
            statement.setInt(1, question.getId());
            statement.setString(2, question.getText());
            statement.setInt(4, question.getTestId());
            statement.setInt(3, question.getScores());
            InterfaceDAO<Option> optionMySQLDAO = new MySQLDAOFactory().getOptionDAO();
            for (Option option : question.getAnswerOptions()) {
                optionMySQLDAO.insert(option);
            }
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (modifiedRows > 0);
    }

    @Override
    public boolean update(Question entity) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_QUESTION);
        ) {
            statement.setString(1, entity.getText());
            statement.setInt(3, entity.getTestId());
            statement.setInt(2, entity.getScores());
            statement.setInt(4, entity.getId());
            modifiedRows = statement.executeUpdate();

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public boolean delete(int id) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_QUESTION)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_ALL_QUESTIONS)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question question = find(rs.getInt("id"));
                if (question != null) {
                    questions.add(question);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(e.getClass(),e.getMessage());
        }

        return questions;
    }

    @Override
    public List<Question> getAll(String where,String...params) {
        return null;
    }
}
