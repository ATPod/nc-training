package by.training.nc.dev5.web.controller;

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
@Scope("session")
public class LoginController {

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

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "redirect:/home";
    }
}
