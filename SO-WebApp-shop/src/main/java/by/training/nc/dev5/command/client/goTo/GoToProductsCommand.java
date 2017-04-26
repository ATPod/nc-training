package by.training.nc.dev5.command.client.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;
import by.training.nc.dev5.services.OrderingService;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToProductsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        int orderingId = Integer.valueOf(request.getParameter(Parameters.ID_ORDERING));

        List<Product> productList;

        try {
            productList = OrderingService.findOrderingById(orderingId).getProducts();
            request.getSession().setAttribute(Parameters.LIST_PRODUCTS_ORDERING, productList);
            page = ConfigurationManager.getProperty("path.page.client_products");
        }
        catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_products");
        }

        return page;
    }
}