package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    @Qualifier("ProductService")
    IProductService productService;

    @RequestMapping(value = {"/admin_products"}, method = RequestMethod.GET)
    protected String openProducts(ModelMap modelMap) {
        try {
            modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());
        }
        catch (DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.ADMIN_PRODUCTS;
    }

    @RequestMapping(value = {"/client_catalog"}, method = RequestMethod.GET)
    protected String openCatalog(ModelMap modelMap) {
        try {
            modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());
        } catch (DaoException e) {
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.CLIENT_CATALOG;
    }

    @RequestMapping(value = {"/client_bag"}, method = RequestMethod.GET)
    protected String bag() {
        return JspPaths.CLIENT_BAG;
    }

    @RequestMapping(value = {"/client_add_to_bag"}, method = RequestMethod.POST)
    protected String addToBag(HttpServletRequest request, ModelMap modelMap) {

        List<Product> bag = (List<Product>) request.getSession().getAttribute(Parameters.BAG);
        int productId = Integer.valueOf(request.getParameter(Parameters.ID_PRODUCT));

        Product product = null;

        try {
            product = productService.getProductByID(Integer.valueOf(productId));
            bag.add(product);
            request.getSession().setAttribute(Parameters.BAG, bag);
            modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.CLIENT_CATALOG;
    }

    @RequestMapping(value = {"/client_remove_from_bag"}, method = RequestMethod.POST)
    protected String removeFromBag(HttpServletRequest request, ModelMap modelMap) {

        List<Product> bag = (List<Product>) request.getSession().getAttribute(Parameters.BAG);
        int productId = Integer.valueOf(request.getParameter(Parameters.ID_PRODUCT));

        Product product = null;

        try {
            product = productService.getProductByID(productId);
            bag.remove(product);
            request.getSession().setAttribute(Parameters.BAG, bag);
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.CLIENT_BAG;
    }


    @RequestMapping(value = {"/admin_add_product"}, method = RequestMethod.POST)
    protected String add(@RequestParam(Parameters.TITLE_PRODUCT)String title, @RequestParam(Parameters.PRICE_PRODUCT)String price,
                         HttpServletRequest request, ModelMap modelMap) {
        try {
            productService.addProduct(title, Integer.valueOf(price));
            modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());
        } catch (DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.ADMIN_PRODUCTS;
    }

    @RequestMapping(value = {"/admin_update_product"}, method = RequestMethod.POST)
    protected String update(@RequestParam(Parameters.ID_PRODUCT) int productId, @RequestParam(Parameters.TITLE_PRODUCT)String title,
                            @RequestParam(Parameters.PRICE_PRODUCT)String price,
                            HttpServletRequest request, ModelMap modelMap) {

        try {
            if (price.equals("")) {
                productService.updateProduct(productId, title, -1);
            }
            else {
                productService.updateProduct(productId, title, Integer.valueOf(price));
            }
            modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.ADMIN_PRODUCTS;
    }

    @RequestMapping(value = {"/admin_remove_product"}, method = RequestMethod.POST)
    protected String update(@RequestParam(Parameters.ID_PRODUCT) int productId,
                            HttpServletRequest request, ModelMap modelMap) {

        try {
            productService.removeProduct(productId);
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.ADMIN_PRODUCTS;
    }
}
