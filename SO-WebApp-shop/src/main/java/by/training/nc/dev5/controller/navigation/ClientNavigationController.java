package by.training.nc.dev5.controller.navigation;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.entity.Ordering;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IOrderingService;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
@SessionAttributes({"user", "bag"})
public class ClientNavigationController {

    @Autowired
    @Qualifier("OrderingService")
    IOrderingService orderingService;

    @Autowired
    @Qualifier("ProductService")
    IProductService productService;

    @RequestMapping(value = {"/orderings"}, method = RequestMethod.GET)
    public String openOrderings(@ModelAttribute("user")Client client, ModelMap modelMap) {
        try {
            modelMap.addAttribute("orderingList", orderingService.getByClient(client.getId()));
        }
        catch (DaoException e) {
            return "error";
        }
        return JspPaths.CLIENT_ORDERINGS;
    }

    @RequestMapping(value = {"/settings"}, method = RequestMethod.GET)
    protected String openSettings(ModelMap modelMap) {
        return JspPaths.CLIENT_SETTINGS;
    }

    @RequestMapping(value = {"/catalog"}, method = RequestMethod.GET)
    protected String openCatalog(ModelMap modelMap) {
        try {
            modelMap.addAttribute("productList", productService.getAllProducts());
        } catch (DaoException e) {
            return "error";
        }
        return JspPaths.CLIENT_CATALOG;
    }

    @RequestMapping(value = {"/bag"}, method = RequestMethod.GET)
    protected String openBag(@ModelAttribute("bag") List<Product> bag, ModelMap modelMap) {
        int sum = 0;
        for (Product product: bag){
            sum += product.getPrice();
        }
        modelMap.addAttribute("sum", sum);
        return JspPaths.CLIENT_BAG;
    }

    @RequestMapping(value = "/products_ordering", method = RequestMethod.GET)
    protected String openProductsOrdering(@RequestParam(value = "orderingId", defaultValue = "-1") int orderingId, ModelMap modelMap) {
        try {
            if (orderingId == -1){
                return "redirect:/client/orderings";
            }
            Ordering ordering = orderingService.findOrderingById(orderingId);
            modelMap.addAttribute("productListOrdering", ordering.getProducts());
        }
        catch (NotFoundException | DaoException e) {
            return "error";
        }
        return JspPaths.CLIENT_PRODUCTS_ORDERING;
    }
}
