package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes({"user", "bag"})
public class ProductController {

    @Autowired
    @Qualifier("ProductService")
    IProductService productService;

    @RequestMapping(value = {"/client/add_to_bag"}, method = RequestMethod.POST)
    protected String addToBag(@ModelAttribute("bag") ArrayList<Product> bag,
                              @RequestParam("productId") int productId, ModelMap modelMap) {
        try {
            bag.add(productService.getProductByID(productId));
            modelMap.addAttribute("bag", bag);
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/client/catalog";
    }

    @RequestMapping(value = {"/client/remove_from_bag"}, method = RequestMethod.POST)
    protected String removeFromBag(@ModelAttribute("bag") ArrayList<Product> bag,
                                   @RequestParam("productId") int productId, ModelMap modelMap) {
        try {
            bag.remove(productService.getProductByID(productId));
            modelMap.addAttribute("bag", bag);
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/client/bag";
    }

    @RequestMapping(value = {"/admin/add_product"}, method = RequestMethod.POST)
    protected String addProduct(@RequestParam("productTitle") String title,
                                @RequestParam("productPrice") int price, ModelMap modelMap) {
        try {
            productService.addProduct(title, price);
        } catch (DaoException e) {
            return "error";
        }
        return "redirect:/admin/products";
    }

    @RequestMapping(value = {"/admin/update_product"}, method = RequestMethod.POST)
    protected String updateProduct(@RequestParam("productId") int productId,
                                   @RequestParam("productTitle")String title,
                                   @RequestParam("productPrice") String price, ModelMap modelMap) {

        try {
            if (price.equals("")) {
                productService.updateProduct(productId, title, -1);
            }
            else {
                productService.updateProduct(productId, title, Integer.valueOf(price));
            }
            modelMap.addAttribute("productList", productService.getAllProducts());
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/admin/products";
    }

    @RequestMapping(value = {"/admin/remove_product"}, method = RequestMethod.POST)
    protected String update(@RequestParam("productId") int productId, ModelMap modelMap) {
        try {
            productService.removeProduct(productId);
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/admin/products";
    }
}
