package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;

public class UpdatePasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        String password = request.getParameter(Parameters.PASSWORD);
        int clientId = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        try {
            ClientService.updateClientPassword(clientId, password);
            page = ConfigurationManager.getProperty("path.page.client_settings");
        } catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_settings");
        }

        return page;
    }
}