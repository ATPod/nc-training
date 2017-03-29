package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OptionMySQLDAO implements InterfaceDAO<Option>{
    @Override
    public Test find(int id) {
        List<Test> tests = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (tests.size() > 0) {
            return tests.get(0);
        } else {

            return null;
        }
    }

    @Override
    public boolean insert(Test test) {
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
    public boolean delete(Test test) {
        int modifiedRows = 0;
        try (Connection connection = MySQLDAOFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM tests WHERE tests.id = ?")
        ) {
            statement.setInt(1, test.getId());
            modifiedRows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (0 < modifiedRows);
    }

    @Override
    public List<Test> getAll(String where) {
        List<Test> tests = new ArrayList<>();
        String sql = "SELECT * FROM tests " + where + " ;";
        try (Connection connection = MySQLDAOFactory.getConnection();
             Statement statement = connection.createStatement()
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
