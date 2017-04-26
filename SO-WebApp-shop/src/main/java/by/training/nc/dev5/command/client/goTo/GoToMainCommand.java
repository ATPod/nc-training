package by.training.nc.dev5.command.client.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entities.Product;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GoToMainCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        try {
            List<Product> productList = ProductService.getAllProducts();
            request.getSession().setAttribute(Parameters.LIST_PRODUCTS, productList);
            page = ConfigurationManager.getProperty("path.page.client_main");
        }
        catch (DAOException e){
            request.setAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.client_main");
        }

        return page;
    }
}