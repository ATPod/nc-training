package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpdateEmailCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String email = request.getParameter(Parameters.EMAIL);
        int clientId = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        Matcher matcherEmail = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z").matcher(email);

        if (matcherEmail.matches()) {
            try {
                ClientService.updateClientEmail(clientId, email);
                HttpSession session = request.getSession(true);
                session.setAttribute(Parameters.EMAIL, email);
                page = ConfigurationManager.getProperty("path.page.client_settings");
            } catch (NotFoundException | DAOException e) {
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
                page = ConfigurationManager.getProperty("path.page.client_settings");
                return page;
            }
        }
        else{
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.syntax_error"));
            page = ConfigurationManager.getProperty("path.page.client_settings");
        }

        return page;
    }
}