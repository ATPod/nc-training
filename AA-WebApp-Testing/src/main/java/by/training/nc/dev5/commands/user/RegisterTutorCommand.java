package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;

import javax.servlet.http.HttpServletRequest;

public class RegisterTutorCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> dao = factory.getUserDAO();
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String subject=request.getParameter("subject");
        Tutor tutor = new Tutor(0, name, surname, login, password, subject);
        dao.insert(tutor);
        return JspPaths.LOGIN_PAGE_PATH;
    }
}
