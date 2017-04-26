package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.client.goTo.GoToMainCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddToBagCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        List <Product> bag = (List <Product>)request.getSession().getAttribute(Parameters.BAG);
        int productId = Integer.valueOf(request.getParameter(Parameters.ID_PRODUCT));

        Product product = null;

        try {
            product = ProductService.getProductByID(Integer.valueOf(productId));
            bag.add(product);
            request.getSession().setAttribute(Parameters.BAG, bag);
            page = new GoToMainCommand().execute(request);
        } catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_main");
            return page;
        }

        return page;
    }
}