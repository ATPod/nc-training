package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.client.goTo.GoToOrderingsCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.OrderingService;

import javax.servlet.http.HttpServletRequest;

public class PayForOrderingCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String orderingId = request.getParameter(Parameters.ID_ORDERING);

        try {
            OrderingService.updateOrderingPayment(Integer.valueOf(orderingId));
            page = new GoToOrderingsCommand().execute(request);
        } catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_orderings");
        }

        return page;
    }
}