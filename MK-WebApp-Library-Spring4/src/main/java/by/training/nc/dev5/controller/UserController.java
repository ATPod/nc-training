package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Loan;
import by.training.nc.dev5.entity.User;
import by.training.nc.dev5.exception.DbException;
import by.training.nc.dev5.jpaservice.LoanService;
import by.training.nc.dev5.jpaservice.UserService;
import by.training.nc.dev5.util.Attributes;
import by.training.nc.dev5.util.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;


@Controller
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private LoanService loanService;


    @RequestMapping(value = {"/users"})
    String getUsers(Model modelMap, HttpServletRequest request) {

        List<User> users = Collections.emptyList();
        try {
            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.USERS, users);

        return Pages.USERS_PAGE;
    }

    @RequestMapping(value = {"/users/delete"})
    String deleteUsers(@RequestParam("user-delete-id") int id, Model modelMap, HttpServletRequest request) {

        List<User> users = Collections.emptyList();
        try {
            userService.deleteUser(id);
            users = userService.selectUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }
        modelMap.addAttribute(Attributes.USERS, users);

        return Pages.USERS_PAGE;
    }


    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    String showLogin() {

        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    String login(@RequestParam("user-name") String name, @RequestParam("user-password") String password,
                 HttpServletRequest request, ExtendedModelMap modelMap) {

        try {
            User user = userService.findByNameAndPassword(name, password);
            if (user != null) {
                request.getSession().setAttribute(Attributes.USER, user);
                List<Loan> loans = loanService.selectLoans();
                modelMap.addAttribute(Attributes.LOANS, loans);
                /*request.getSession().setAttribute(Attributes.LOANS, loanService.selectLoans());*/
                loans.forEach(System.out::println);
                return Pages.LOANS_PAGE;
            } else {
                return Pages.LOGIN_PAGE;
            }
        } catch (DbException ex) {
            return Pages.ERROR;
        }
    }

    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    String showSignup( ){
        return Pages.SIGNUP_PAGE;
    }


    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    String signup(@RequestParam("user-name") String name, @RequestParam("user-password") String password,
                  @RequestParam("user-role") String role,HttpServletRequest request, ExtendedModelMap modelMap) {
        try {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
            userService.insertUser(user);// лучше возвращать юзера и проверять есть ли уже такой
            return Pages.LOGIN_PAGE;
            } catch (DbException e) {
            e.printStackTrace();
        }
        return "/signup";
    }

    @RequestMapping(value = "/logout")
    public String logoutUser(HttpSession session) {

        session.setAttribute("user", null);
        session.invalidate();
        return Pages.LOGIN_PAGE;
    }
}
