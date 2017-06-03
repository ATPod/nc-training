package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.PersonDto;
import by.training.nc.dev5.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Created by Nikita on 24.05.2017.
 */
@Controller
@SessionAttributes("user")
public class LoginController {
    private final AuthenticationService authenticationService;

    @Autowired
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @RequestMapping("/home")
    public String showHomePage(ModelMap modelMap) {
        if (modelMap.get("user") != null) {
            return "main";
        }
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(
            ModelMap modelMap,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        PersonDto user = authenticationService.authenticate(username, password);

        if (user == null) {
            modelMap.addAttribute("loginErrorMessage",
                    "Invalid username/password pair");

            return "login";
        }

        modelMap.addAttribute("user", user);

        return "redirect:/home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "redirect:/home";
    }
}
