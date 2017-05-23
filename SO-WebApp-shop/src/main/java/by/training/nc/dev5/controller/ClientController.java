package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClientController {

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @RequestMapping(value = {"/admin_clients"}, method = RequestMethod.GET)
    protected String openClients(HttpServletRequest request, ModelMap modelMap) {
        try {
            modelMap.addAttribute(Parameters.LIST_CLIENTS, clientService.getAllClients());
        }
        catch (DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.ADMIN_CLIENTS;
    }

    @RequestMapping(value = {"/client_settings"}, method = RequestMethod.GET)
    protected String settings(HttpServletRequest request, ModelMap modelMap) {

        if ((byte)request.getSession().getAttribute(Parameters.BLACK_LIST) == 1){
            modelMap.addAttribute(Parameters.BLACK_LIST_MSG,  MessageManager.getProperty("message.black_list"));
        }
        else {
            modelMap.addAttribute(Parameters.BLACK_LIST_MSG, "");
        }
        return JspPaths.CLIENT_SETTINGS;
    }

    @RequestMapping(value = {"/client_update"}, method = RequestMethod.POST)
    protected String update(@RequestParam(Parameters.CHANGE_EMAIL)String email, @RequestParam(Parameters.CHANGE_FIRST_NAME)String firstName,
                            @RequestParam(Parameters.CHANGE_LAST_NAME)String lastName, @RequestParam(Parameters.PASSWORD)String password,
                            HttpServletRequest request, ModelMap modelMap) {

        int clientId = (Integer) request.getSession().getAttribute(Parameters.ID_CLIENT);

        try {
            clientService.updateClientProfile(clientId, email, firstName, lastName, password);
            Client client = clientService.findClientById(clientId);
            request.getSession().setAttribute(Parameters.EMAIL, client.getEmail());
            request.getSession().setAttribute(Parameters.FIRST_NAME, client.getFirstname());
            request.getSession().setAttribute(Parameters.LAST_NAME, client.getLastname());

        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }
        return JspPaths.CLIENT_SETTINGS;
    }


    @RequestMapping(value = {"/admin_change_black_list"}, method = RequestMethod.POST)
    protected String update(@RequestParam(Parameters.ID_CLIENT) int clientId,
                            HttpServletRequest request, ModelMap modelMap) {
        try {
            if (clientService.checkBlackList(clientId)){
                clientService.updateClientBlackList(clientId, false);
            }
            else{
                clientService.updateClientBlackList(clientId, true);
            }
            modelMap.addAttribute(Parameters.LIST_CLIENTS, clientService.getAllClients());
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.ADMIN_CLIENTS;
    }
}
