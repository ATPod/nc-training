package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.services.IAdministratorService;
import by.training.nc.dev5.services.IClientService;
import by.training.nc.dev5.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@SessionAttributes({"user", "bag"})

public class UserController {

    @Autowired
    @Qualifier("ClientService")
    IClientService clientService;

    @RequestMapping(value = "/logout", method = {RequestMethod.POST, RequestMethod.GET})
    public String logoutUser(SessionStatus status) {
        status.setComplete();
        return JspPaths.LOGIN;
    }


    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String register(@RequestParam("userEmail")String email,
                           @RequestParam("userPassword") String password,
                           @RequestParam("userFirstName")String firstName,
                           @RequestParam("userLastName") String lastName,
                           Locale locale,
                           ModelMap modelMap) {

        Matcher matcherFName = Pattern.compile("^[a-zA-Z]+$").matcher(firstName);
        Matcher matcherLName = Pattern.compile("^[a-zA-Z]+$").matcher(lastName);
        Matcher matcherEmail = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z").matcher(email);

        if (matcherEmail.matches() && matcherFName.matches() && matcherLName.matches()) {

            try {
                clientService.addClient(firstName, lastName, email, password);
                return "redirect:/login";

            } catch (DaoException e) {
                return "error";
            } catch (DuplicationException e) {
                return "redirect:/registration?error=0";
            }
        }
        else{
            return "redirect:/registration?error=1";
        }
    }
}
