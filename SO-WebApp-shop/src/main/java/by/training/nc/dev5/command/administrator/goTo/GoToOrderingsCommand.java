package by.training.nc.dev5.command.administrator.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.OrderingService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToOrderingsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        List<Ordering> orderingList;

        try {
            orderingList = OrderingService.getAllOrderings();
        }
        catch (DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            return ConfigurationManager.getProperty("path.page.admin_orderings");
        }

        request.getSession().setAttribute(Parameters.LIST_ORDERINGS, orderingList);

        return ConfigurationManager.getProperty("path.page.admin_orderings");
    }
}