package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.IAdministratorService;
import by.training.nc.dev5.services.IClientService;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @Autowired
    @Qualifier("AdministratorService")
    IAdministratorService administratorService;

    @Autowired
    @Qualifier("ProductService")
    IProductService productService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.POST)
    protected String login(@RequestParam("userEmail")String email, @RequestParam("userPassword") String password,
                           HttpServletRequest request, ModelMap modelMap) {

        Pattern pattern =  Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()){
            try {
                Client client = clientService.findClientByParameters(email, password);

                request.getSession().setAttribute(Parameters.ID_CLIENT, client.getId());
                request.getSession().setAttribute(Parameters.EMAIL, client.getEmail());
                request.getSession().setAttribute(Parameters.FIRST_NAME, client.getFirstname());
                request.getSession().setAttribute(Parameters.LAST_NAME, client.getLastname());
                request.getSession().setAttribute(Parameters.BLACK_LIST, client.getBlacklist());
                request.getSession().setAttribute(Parameters.BAG, new ArrayList<Product>());

                modelMap.addAttribute(Parameters.LIST_PRODUCTS, productService.getAllProducts());

                return JspPaths.CLIENT_CATALOG;
            }
            catch (NotFoundException e){
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.login_error"));
                return JspPaths.LOGIN;
            }
            catch (DaoException e){
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
                return JspPaths.LOGIN;
            }
        }
        else {
            try {
                Administrator administrator = administratorService.findAdministratorByParameters(email, password);

                request.getSession().setAttribute(Parameters.ID_ADMIN, administrator.getId());
                request.getSession().setAttribute(Parameters.NAME_ADMIN, administrator.getName());

                modelMap.addAttribute(Parameters.LIST_CLIENTS, clientService.getAllClients());

                return JspPaths.ADMIN_CLIENTS;
            }
            catch (NotFoundException e){
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.login_error"));
                return JspPaths.LOGIN;
            }
            catch (DaoException e){
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.server_error"));
                return JspPaths.LOGIN;
            }
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public String logoutUser(HttpSession session) {
        session.invalidate();
        return JspPaths.INDEX;
    }

    @RequestMapping(value = "/registration", method = {RequestMethod.GET})
    public String openRegistration(ModelMap modelMap) {
        return JspPaths.REGISTRATION;
    }

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String register(@RequestParam("userEmail")String email, @RequestParam("userPassword") String password,
                           @RequestParam("userFirstName")String firstName, @RequestParam("userLastName") String lastName,
                           HttpServletRequest request, ModelMap modelMap) {

        Matcher matcherFName = Pattern.compile("^[a-zA-Z]+$").matcher(firstName);
        Matcher matcherLName = Pattern.compile("^[a-zA-Z]+$").matcher(lastName);
        Matcher matcherEmail = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z").matcher(email);

        if (matcherEmail.matches() && matcherFName.matches() && matcherLName.matches()) {

            try {
                clientService.addClient(firstName, lastName, email, password);
                Client client = clientService.findClientByParameters(email, password);

                HttpSession session = request.getSession(true);
                session.setAttribute(Parameters.ID_CLIENT, client.getId());
                session.setAttribute(Parameters.EMAIL, email);
                session.setAttribute(Parameters.FIRST_NAME, firstName);
                session.setAttribute(Parameters.LAST_NAME, lastName);

                modelMap.addAttribute(Parameters.LIST_CLIENTS, clientService.getAllClients());

                return JspPaths.CLIENT_CATALOG;

            } catch (NotFoundException| DaoException e) {
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
                return JspPaths.REGISTRATION;
            } catch (DuplicationException e) {
                SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
                modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.duplic_error"));
                return JspPaths.REGISTRATION;
            }
        }
        else{
            modelMap.addAttribute(Parameters.ERROR,  MessageManager.getProperty("message.syntax_error"));
            return JspPaths.REGISTRATION;
        }
    }
}
