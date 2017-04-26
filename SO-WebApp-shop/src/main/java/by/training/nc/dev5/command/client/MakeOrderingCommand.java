package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;
import by.training.nc.dev5.services.OrderingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MakeOrderingCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List<Product> bag = (List <Product>)request.getSession().getAttribute(Parameters.BAG);
        Integer idClient = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        if (bag.size() == 0){
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.empty_bag"));
            page = ConfigurationManager.getProperty("path.page.client_bag");
            return page;
        }

        try {
            if (ClientService.checkBlackList(idClient)){
                request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.black_list"));
                page = ConfigurationManager.getProperty("path.page.client_bag");
                return page;
            }
            OrderingService.addOrdering(idClient, bag);
            bag.clear();
            request.getSession().setAttribute(Parameters.BAG, bag);
            page = ConfigurationManager.getProperty("path.page.client_bag");
        } catch (DAOException | NotFoundException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_bag");
            return page;
        }

        return page;
    }
}