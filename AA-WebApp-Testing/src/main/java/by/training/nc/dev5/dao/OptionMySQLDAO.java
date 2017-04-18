package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.sql.SQLQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OptionMySQLDAO implements InterfaceDAO<Option> {
    @Override
    public Option find(int id) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.FIND_OPTION)
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                rs.next();
                Option option = new Option();
                option.setId(rs.getInt("id"));
                option.setNumber(rs.getInt("number"));
                option.setText(rs.getString("text"));
                option.setRightness(rs.getBoolean("rightness"));
                option.setQuestionId(rs.getInt("question_id"));
                return option;
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return null;
    }
    @Override
    public int insert(Option option) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement
                     (SQLQueries.INSERT_OPTION, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, option.getText());
            statement.setInt(2, option.getNumber());
            statement.setBoolean(3, option.isRightness());
            statement.setInt(4, option.getQuestionId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error! Option is not inserted!");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int optionId = generatedKeys.getInt(1);
                option.setId(optionId);
                return optionId;
            } else {
                throw new SQLException("Creating option failed, no ID obtained.");
            }
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }

        return 0;
    }

    @Override
    public boolean update(Option entity) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.UPDATE_OPTION);
        ) {
            statement.setString(1, entity.getText());
            statement.setInt(2, entity.getNumber());
            statement.setBoolean(3, entity.isRightness());
            statement.setInt(5, entity.getId());
            statement.setInt(4, entity.getQuestionId());
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
             PreparedStatement statement = connection.prepareStatement(SQLQueries.DELETE_OPTION)
        ) {
            statement.setInt(1, id);
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<Option> getAll() {
        List<Option> options = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_ALL_OPTIONS)
        ) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Option option = find(rs.getInt("id"));
                if (option != null) {
                    options.add(option);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(),e.getMessage());
        }

        return options;
    }

    @Override
    //params-параметры для запроса
    public List<Option> getAll(String where,String...params) {
        return null;
    }

    @Override
    public List<Option> getAll(String where, Integer... params) {
        TestingSystemLogger.INSTANCE.logDebug(getClass(), "invoke getAll method");
        List<Option> options = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(where)
        ) {
            int paramAmount = params.length;
            for (int i = 0; i < paramAmount; i++) {
                statement.setInt((i + 1), params[i]);
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Option option = find(rs.getInt("id"));
                if (option != null) {
                    options.add(option);
                }
            }

        } catch (SQLException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
        }
        return options;
    }
}
