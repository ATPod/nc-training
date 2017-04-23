package by.training.nc.dev5.command.common;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Client;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String firstName = request.getParameter(Parameters.FIRST_NAME).trim();
        String lastName  = request.getParameter(Parameters.LAST_NAME).trim();
        String email     = request.getParameter(Parameters.EMAIL).trim();
        String password  = request.getParameter(Parameters.PASSWORD).trim();

        Matcher matcherFName = Pattern.compile("^[a-zA-Z]+$").matcher(firstName);
        Matcher matcherLName = Pattern.compile("^[a-zA-Z]+$").matcher(lastName);
        Matcher matcherEmail = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z").matcher(email);

        if (matcherEmail.matches() && matcherFName.matches() && matcherLName.matches()) {

            try {
                ClientService.addClient(firstName, lastName, email, password);
                Client client = ClientService.findClientByParameters(email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute(Parameters.ID_CLIENT, client.getId());
                session.setAttribute(Parameters.EMAIL, email);
                session.setAttribute(Parameters.FIRST_NAME, firstName);
                session.setAttribute(Parameters.LAST_NAME, lastName);

                page = ConfigurationManager.getProperty("path.page.client_main");
            } catch (NotFoundException| DAOException e) {
                request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
                page = ConfigurationManager.getProperty("path.page.registration");
            } catch (DuplicationException e) {
                request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.duplic_error"));
                page = ConfigurationManager.getProperty("path.page.registration");
            }
        }
        else{
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.syntax_error"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }

        return page;
    }
}
