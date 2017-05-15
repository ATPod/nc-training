package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes(value = "sessionUser")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginUserForm(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute("user") User user, ModelMap model) {
        String login = user.getLogin();
        String password = user.getPassword();
        try {
            User authorizedUser = userService.getAuthorizedUser(login, password);
            if (authorizedUser != null) {
                model.addAttribute("sessionUser", authorizedUser);
                if (authorizedUser.getUserType().equals("STUDENT")) {
                    return "student_profile";
                } else {
                    return "tutor_profile";
                }
            } else {
                model.addAttribute("errorMessage", "No such user!");
                return "error";
            }
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error!");
            return "error";
        }
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logoutUser(@ModelAttribute("user") User user, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "home";
    }


}
