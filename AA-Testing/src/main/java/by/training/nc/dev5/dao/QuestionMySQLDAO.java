package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionMySQLDAO implements InterfaceDAO<Question> {
    @Override
    public Question find(int id) {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = MySQLDAOFactory.getConnection();
             Statement statement = connection.createStatement()
        ) {
            questions = getAll("WHERE id=" + id + " LIMIT 0,1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (questions.size() > 0) {
            return questions.get(0);
        }
        return null;
    }

    @Override
    public boolean insert(Question question) {
        try (Connection connection = MySQLDAOFactory.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String insertTestSQL = String.format("INSERT INTO tests(id,name,subject,tutor_id) values('%d','%s','%s','%d');",
                    test.getId(), test.getName(), test.getSubject(), test.getAuthorId());
            //executeUpdate returns amount of rows which were changed
            statement.executeUpdate(insertTestSQL);
            ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
            int result = resultSet.getInt(1);
            test.setId(result);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (test.getId() > 0);
    }

    @Override
    public boolean update(Test test) {
        int modifiedRows = 0;
        String updateTestSQL = String.format(
                "UPDATE tests SET name = '%s', subject = '%s', tutor_id = '%d', WHERE tests.id = %d",
                test.getName(), test.getSubject(), test.getAuthorId(), test.getId()
        );
        try (Connection connection = MySQLDAOFactory.getConnection();
             Statement statement = connection.createStatement()
        ) {
            modifiedRows = statement.executeUpdate(updateTestSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return (0 < modifiedRows);
    }

    @Override
    public boolean delete(Question question) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM questions WHERE questions.id = ?")
        ) {
            statement.setInt(1, question.getId());
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<Question> getAll(String where) {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions " + where + " ;";
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM ?  ?   ;")
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Test test = new Test();
                test.setId(rs.getInt("id"));
                test.setName(rs.getString("name"));
                tests.add(test);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tests;
    }
}
