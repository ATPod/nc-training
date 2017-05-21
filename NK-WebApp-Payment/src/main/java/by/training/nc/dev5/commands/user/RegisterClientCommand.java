package by.training.nc.dev5.commands.user;

import by.training.nc.dev5.commands.Command;
import by.training.nc.dev5.dao.ClientMySQLDAO;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;

public class RegisterClientCommand extends AbstractCommand implements Command {
    public String execute(HttpServletRequest request) {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ClientService.insertClient(name,login,password);
        return JspPaths.LOGIN_PAGE_PATH;
    }
}
