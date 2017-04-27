package by.training.nc.dev5.command.administrator;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.administrator.goTo.GoToProductsCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ProductService;

import javax.servlet.http.HttpServletRequest;

public class AddProductCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String title = request.getParameter(Parameters.TITLE_PRODUCT);
        String price = request.getParameter(Parameters.PRICE_PRODUCT);

        try {
            ProductService.addProduct(title, Integer.valueOf(price));
            page = new GoToProductsCommand().execute(request);
        } catch (DAOException e) {
            request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.admin_products");
        }

        return page;
    }
}