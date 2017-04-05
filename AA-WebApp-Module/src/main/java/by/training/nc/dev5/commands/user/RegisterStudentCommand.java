package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Commands;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;

import javax.servlet.http.HttpServletRequest;

public class RegisterStudentCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> dao = factory.getUserDAO();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Student student = new Student(0, name, surname, login, password, 0);
        dao.insert(student);
        return Commands.REGISTERSTUDENT.redirectJSP;
    }
}
