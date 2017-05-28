package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.entities.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginUserForm(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logoutUser(@ModelAttribute("user") User user,HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "home";
    }
    @RequestMapping(value = "/studentProfile", method = RequestMethod.GET)
    public String showStudentProfile(ModelMap model) {
        return "student_profile";}
    @RequestMapping(value = "/tutorProfile", method = RequestMethod.GET)
    public String showTutorProfile(ModelMap model, HttpSession session) {
        model.addAttribute("sessionUser",session.getAttribute("sessionUser"));
        System.out.println("Session="+session.getAttribute("sessionUser"));
        return "tutor_profile";
    }



}
