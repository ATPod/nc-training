package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IClientService;
import by.training.nc.dev5.services.IOrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@SessionAttributes({"user", "bag"})
public class OrderingController {

    @Autowired
    @Qualifier("OrderingService")
    IOrderingService orderingService;

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @RequestMapping(value = {"/client/make_ordering"}, method = RequestMethod.POST)
    public String makeOrdering (@ModelAttribute("bag")ArrayList<Product> bag,
                                @ModelAttribute("user") Client client,
                                ModelMap modelMap) {
        try {
            orderingService.addOrdering(client.getId(), bag);
            bag.clear();
            modelMap.addAttribute("bag", bag);
        } catch (DaoException | NotFoundException e) {
            return "error";
        }
        return "redirect:/client/bag";
    }

    @RequestMapping(value = {"/client/pay_for_ordering"}, method = RequestMethod.POST)
    public String payForOrdering (@RequestParam("orderingId") int orderingId,
                                  @ModelAttribute("user") Client client,
                                  ModelMap modelMap) {
        try {
            orderingService.updateOrderingPayment(orderingId);
            modelMap.addAttribute("orderingList", orderingService.getByClient(client.getId()));
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/client/orderings";
    }
}
