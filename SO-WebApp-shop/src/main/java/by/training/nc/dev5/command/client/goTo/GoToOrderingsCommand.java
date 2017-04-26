package by.training.nc.dev5.command.client.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToOrderingsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        int clientId = (Integer)request.getSession().getAttribute(Parameters.ID_CLIENT);

        List<Ordering> orderingList;

        try {
            orderingList = (List)ClientService.findClientById(clientId).getOrderings();
            request.getSession().setAttribute(Parameters.LIST_ORDERINGS, orderingList);
            page = ConfigurationManager.getProperty("path.page.client_orderings");
        }
        catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_orderings");
        }

        return page;
    }
}