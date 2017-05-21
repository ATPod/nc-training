package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.IClientService;
import by.training.nc.dev5.services.IOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderingController {

    @Autowired
    @Qualifier("OrderingService")
    IOrderingService orderingService;

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @RequestMapping(value = {"/admin_orderings"}, method = RequestMethod.GET)
    public String openOrderings(ModelMap modelMap) {
        try {
            modelMap.addAttribute(Parameters.LIST_ORDERINGS, orderingService.getAllOrderings());
        }
        catch (DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.ADMIN_ORDERINGS;
    }

    @RequestMapping(value = {"/client_orderings"}, method = RequestMethod.GET)
    public String orderings(HttpServletRequest request, ModelMap modelMap) {

        int clientId = (Integer)request.getSession().getAttribute(Parameters.ID_CLIENT);

        try {
            clientService.findClientById(clientId);
            modelMap.addAttribute(Parameters.LIST_ORDERINGS, orderingService.getByClient(clientId));
        }
        catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.CLIENT_ORDERINGS;
    }

    @RequestMapping(value = {"/client_make_ordering"}, method = RequestMethod.POST)
    public String makeOrdering (HttpServletRequest request, ModelMap modelMap) {

        List<Product> bag = (List<Product>) request.getSession().getAttribute(Parameters.BAG);
        Integer idClient = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        if (bag.size() == 0) {
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.empty_bag"));
            return JspPaths.CLIENT_BAG;
        }

        try {
            if (clientService.checkBlackList(idClient)) {
                modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.black_list"));
                return JspPaths.CLIENT_BAG;
            }
            orderingService.addOrdering(idClient, bag);
            bag.clear();
            request.getSession().setAttribute(Parameters.BAG, bag);
        } catch (DaoException | NotFoundException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.CLIENT_BAG;
    }

    @RequestMapping(value = {"/client_pay_for_ordering"}, method = RequestMethod.POST)
    public String payForOrdering (HttpServletRequest request, ModelMap modelMap) {

        String orderingId = request.getParameter(Parameters.ID_ORDERING);
        int clientId = (Integer)request.getSession().getAttribute(Parameters.ID_CLIENT);

        try {
            orderingService.updateOrderingPayment(Integer.valueOf(orderingId));
            modelMap.addAttribute(Parameters.LIST_ORDERINGS, orderingService.getByClient(clientId));
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.CLIENT_ORDERINGS;
    }
}
