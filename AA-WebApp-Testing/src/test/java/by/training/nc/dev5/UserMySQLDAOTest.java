package by.training.nc.dev5;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.List;

public class UserMySQLDAOTest {
    @Test
    public void insertTest() throws SQLException {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Student student = new Student(0, "studentName", "studentSurname",
                "login", "password", 0);
        int id = factory.getUserDAO().insert(student);
        Assert.assertTrue("Не работает метод insert", id!=-1);
    }
    @Test
    public void getAllTest() {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> userDAO = factory.getUserDAO();
        List<User> users = userDAO.getAll();
        Assert.assertNotNull("Не работает метод getAll", users);
        Assert.assertTrue("Не работает метод getAll", users.size() > 0);
    }

    @Test
    public void findTest() throws SQLException {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Student student = new Student(0, "studentName", "studentSurname",
                "login", "password", 0);
        int id = factory.getUserDAO().insert(student);
        Assert.assertTrue("Не работает метод insert", id!=-1);
        student.setId(id);
        Student otherStudent = (Student) factory.getUserDAO().find(id);
        Assert.assertEquals("Не работает метод  find!", student, otherStudent);
    }
    @Test
    public void deleteTest() throws SQLException {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        Student student = new Student(0, "studentName", "studentSurname",
                "login", "password", 0);
        int id = factory.getUserDAO().insert(student);
        Assert.assertTrue("Не работает метод insert", id!=-1);
        boolean result=factory.getUserDAO().delete(id);
        Assert.assertTrue("Не работает метод insert",result);
    }

}
