package by.training.nc.dev5.command.user;

import by.training.nc.dev5.command.ActionCommand;
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
                session.setAttribute(Parameters.FIRST_NAME, client.getFirstName());
                session.setAttribute(Parameters.LAST_NAME, client.getLastName());

                List<Product> productList = ProductService.getAllProducts();
                session.setAttribute("productList", productList);
                session.setAttribute("bag", new ArrayList<Product>());

                page = ConfigurationManager.getProperty("path.page.clientmain");
            }
            catch (NotFoundException e){
                request.setAttribute("errorMessage",  MessageManager.getProperty("message.loginerror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
            catch (DAOException e){
                request.setAttribute("errorMessage",  MessageManager.getProperty("message.servererror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        else {
            try {
                Administrator administrator = AdministratorService.findAdministratorByParameters(email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute("name", administrator.getName());

                page = ConfigurationManager.getProperty("path.page.adminmain");
            }
            catch (NotFoundException e){
                request.setAttribute("errorMessage",  MessageManager.getProperty("message.loginerror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
            catch (DAOException e){
                request.setAttribute("errorMessage",  MessageManager.getProperty("message.servererror"));
                page = ConfigurationManager.getProperty("path.page.login");
            }
        }
        return page;
    }
}
