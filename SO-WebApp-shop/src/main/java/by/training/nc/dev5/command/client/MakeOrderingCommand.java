package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.OrderingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MakeOrderingCommand implements ActionCommand {

    private static final String PARAM_NAME_BAG = "bag";
    private static final String PARAM_NAME_ID  = "idClient";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Product> bag = (List <Product>)request.getSession().getAttribute(PARAM_NAME_BAG);
        Integer idClient = (Integer) request.getSession().getAttribute(PARAM_NAME_ID);

        try {
            OrderingService.addOrdering(idClient, bag);
        } catch (DAOException e) {
            request.setAttribute("errorMessage",  MessageManager.getProperty("message.servererror"));
            page = ConfigurationManager.getProperty("path.page.bag");
            return page;
        }

        bag.clear();

        HttpSession session = request.getSession(true);
        session.setAttribute("bag", bag);

        page = ConfigurationManager.getProperty("path.page.bag");

        return page;
    }
}