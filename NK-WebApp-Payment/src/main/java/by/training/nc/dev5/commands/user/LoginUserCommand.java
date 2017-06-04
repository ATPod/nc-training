package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.dao.ClientMySQLDAO;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Admin;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.entities.Person;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserCommand extends AbstractCommand  implements Command {
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Person person = ClientService.login(login,password);
        if (person != null) {
            HttpSession session = request.getSession();
            session.setAttribute("person", person);
            if (person.isStatus() == true) {
                session.setAttribute("type", 2);
                return JspPaths.ADMIN_MENU;
            } else {
                if (person.isStatus() == false) {
                    session.setAttribute("type", 1);
                    return JspPaths.CLIENT_MENU;
                }
            }
        }
        request.setAttribute("error_message", "no users with such pass or login!");
        return null;
    }
}
