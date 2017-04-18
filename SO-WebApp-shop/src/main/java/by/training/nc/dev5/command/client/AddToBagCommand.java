package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
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

    private static final String PARAM_NAME_BAG = "bag";
    private static final String PARAM_NAME_ID  = "idProduct";

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;

        List <Product> bag = (List <Product>)request.getSession().getAttribute(PARAM_NAME_BAG);
        String idProduct = request.getParameter(PARAM_NAME_ID);

        Product product = null;

        try {
            product = ProductService.getProductByID(Integer.valueOf(idProduct));
        } catch (NotFoundException | DAOException e) {
            request.setAttribute("errorMessage",  MessageManager.getProperty("message.servererror"));
            page = ConfigurationManager.getProperty("path.page.clientmain");
            return page;
        }

        bag.add(product);

        HttpSession session = request.getSession(true);
        session.setAttribute("bag", bag);

        page = ConfigurationManager.getProperty("path.page.clientmain");

        return page;
    }
}