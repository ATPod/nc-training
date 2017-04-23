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

public class UpdateLastNameCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String lastName = request.getParameter(Parameters.LAST_NAME);
        int clientId = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        Matcher matcherFName = Pattern.compile("^[a-zA-Z]+$").matcher(lastName);

        if (matcherFName.matches()) {
            try {
                ClientService.updateClientLastName(clientId, lastName);
                request.getSession().setAttribute(Parameters.LAST_NAME, lastName);
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
