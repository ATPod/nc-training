package by.training.nc.dev5.command.administrator;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.administrator.goTo.GoToClientsCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;

public class ChangeBlackListCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        int clientId = Integer.valueOf(request.getParameter(Parameters.ID_CLIENT));

        try {
            if (ClientService.checkBlackList(clientId)){
                ClientService.updateClientBlackList(clientId, false);
            }
            else{
                ClientService.updateClientBlackList(clientId, true);
            }
            page = new GoToClientsCommand().execute(request);
        } catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.admin_clients");
        }

        return page;
    }
}