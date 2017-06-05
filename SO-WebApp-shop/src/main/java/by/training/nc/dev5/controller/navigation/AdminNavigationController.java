package by.training.nc.dev5.controller.navigation;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IClientService;
import by.training.nc.dev5.services.IOrderingService;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"user", "bag"})
public class AdminNavigationController {

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @Autowired
    @Qualifier("OrderingService")
    IOrderingService orderingService;

    @Autowired
    @Qualifier("ProductService")
    IProductService productService;

    @RequestMapping(value = {"/settings"}, method = RequestMethod.GET)
    protected String openSettings(ModelMap modelMap) {
        return JspPaths.ADMIN_SETTINGS;
    }

    @RequestMapping(value = {"/clients"}, method = RequestMethod.GET)
    protected String openClients(ModelMap modelMap) {
        try {
            modelMap.addAttribute("clientList", clientService.getAllClients());
        }
        catch (DaoException e) {
            return "error";
        }
        return JspPaths.ADMIN_CLIENTS;
    }

    @RequestMapping(value = {"/orderings"}, method = RequestMethod.GET)
    public String openOrderings(ModelMap modelMap) {
        try {
            modelMap.addAttribute("orderingList", orderingService.getAllOrderings());
        }
        catch (DaoException e) {
            return "error";
        }
        return JspPaths.ADMIN_ORDERINGS;
    }

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    protected String openProducts(ModelMap modelMap) {
        try {
            modelMap.addAttribute("productList", productService.getAllProducts());
        }
        catch (DaoException e) {
            return "error";
        }
        return JspPaths.ADMIN_PRODUCTS;
    }

    @RequestMapping(value = "/products_ordering", method = RequestMethod.GET)
    protected String openProductsOrdering(@RequestParam(value = "orderingId", defaultValue = "-1") int orderingId,  ModelMap modelMap) {
        try {
            if (orderingId == -1){
                return "redirect:/admin/orderings";
            }
            Ordering ordering = orderingService.findOrderingById(orderingId);
            modelMap.addAttribute("productListOrdering", ordering.getProducts());
        }
        catch (NotFoundException | DaoException e) {
            return "error";
        }
        return JspPaths.ADMIN_PRODUCTS_ORDERING;
    }
}
