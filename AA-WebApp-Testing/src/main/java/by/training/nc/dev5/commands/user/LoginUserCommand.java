package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.commands.Commands;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.dao.UserMySQLDAO;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.sql.SQLQueries;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginUserCommand extends AbstractCommand {
    //вход пользователя в систему
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> dao = factory.getUserDAO();
        List<User> users = dao.getAll(SQLQueries.FIND_BY_LOGIN_PASSWORD, login, password);
        if (users.size()!=0) {
            HttpSession session = request.getSession();
            User registered = users.get(0);
            session.setAttribute("user", registered);
            if (registered instanceof Tutor) {
                session.setAttribute("type",2);
                return Commands.TUTORMENU.redirectJSP;
            } else {
                if (registered instanceof Student) {
                    session.setAttribute("type",1);
                    return Commands.STUDENTMENU.redirectJSP;
                }
            }
        }
        request.setAttribute("error_message","Пользователь с данным логином и паролем отсутствует!");
        return null;

    }
}
