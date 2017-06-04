package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user", "bag"})
public class ClientController {

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @RequestMapping(value = {"/client/update"}, method = RequestMethod.POST)
    protected String updateClient(@ModelAttribute("user") Client client,
                                  @RequestParam("c_email") String email,
                                  @RequestParam("c_firstname") String firstName,
                                  @RequestParam("c_lastname") String lastName,
                                  @RequestParam("password") String password,
                                  ModelMap modelMap) {

        try {
            clientService.updateClientProfile(client.getId(), email, firstName, lastName, password);
            Client updatedClient = clientService.findClientById(client.getId());
            modelMap.addAttribute("user", updatedClient);
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/client/settings";
    }

    @RequestMapping(value = {"/admin/change_black_list"}, method = RequestMethod.POST)
    protected String updateClientBlackList(@RequestParam("clientId") int clientId, ModelMap modelMap) {
        try {
            if (clientService.checkBlackList(clientId)){
                clientService.updateClientBlackList(clientId, false);
            }
            else{
                clientService.updateClientBlackList(clientId, true);
            }
            modelMap.addAttribute("clientList", clientService.getAllClients());
        } catch (NotFoundException | DaoException e) {
            return "error";
        }
        return "redirect:/admin/clients";
    }
}
