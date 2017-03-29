package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.exceptions.StudentLogicException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentMySQLDAO implements InterfaceDAO<Student> {
    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public boolean insert(Student entity) {
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean delete(Student entity) {
        return false;
    }

    @Override
    public List<Student> getAll(String where) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students " + where + " ;";
        try (Connection connection = MySQLDAOFactory.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setBalls(rs.getInt("balls"));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (StudentLogicException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
