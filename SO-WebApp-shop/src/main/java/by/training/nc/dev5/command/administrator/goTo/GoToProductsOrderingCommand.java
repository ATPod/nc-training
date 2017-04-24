package by.training.nc.dev5.command.administrator.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Ordering;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.OrderingService;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToProductsOrderingCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        int orderingId = Integer.valueOf(request.getParameter(Parameters.ID_ORDERING));

        List<Product> productList;

        try {
            productList = OrderingService.findOrderingById(orderingId).getProducts();
        }
        catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            return ConfigurationManager.getProperty("path.page.admin_products_ordering");
        }

        request.getSession().setAttribute(Parameters.LIST_PRODUCTS_ORDERING, productList);

        return ConfigurationManager.getProperty("path.page.admin_products_ordering");
    }
}