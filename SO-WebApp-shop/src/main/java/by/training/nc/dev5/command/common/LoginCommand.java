package by.training.nc.dev5.command.common;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.administrator.goTo.GoToClientsCommand;
import by.training.nc.dev5.command.client.goTo.GoToMainCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Administrator;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.AdministratorService;
import by.training.nc.dev5.services.ClientService;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String email = request.getParameter(Parameters.EMAIL).trim();
        String password = request.getParameter(Parameters.PASSWORD).trim();

        Pattern pattern =  Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            try {
                Client client = ClientService.findClientByParameters(email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute(Parameters.ID_CLIENT, client.getId());
                session.setAttribute(Parameters.EMAIL, client.getEmail());
                session.setAttribute(Parameters.FIRST_NAME, client.getFirstname());
                session.setAttribute(Parameters.LAST_NAME, client.getLastname());
                session.setAttribute(Parameters.BLACK_LIST, client.getBlacklist());
                session.setAttribute(Parameters.BAG, new ArrayList<Product>());

                page = new GoToMainCommand().execute(request);
            }
            catch (NotFoundException e){
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.login_error"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
            catch (DAOException e){
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        else {
            try {
                Administrator administrator = AdministratorService.findAdministratorByParameters(email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute("adminId", administrator.getId());
                session.setAttribute("name", administrator.getName());

                page = new GoToClientsCommand().execute(request);
            }
            catch (NotFoundException e){
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.login_error"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
            catch (DAOException e){
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        return page;
    }
}
