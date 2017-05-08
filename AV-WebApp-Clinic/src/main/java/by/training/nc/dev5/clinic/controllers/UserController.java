package by.training.nc.dev5.clinic.controllers;

import by.training.nc.dev5.clinic.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.inject.Inject;
/**
 * Created by user on 07.05.2017.
 */
@Controller
public class UserController {
    private IUserService userService;

    @Inject
    public UserController(IUserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showHomePage(){
        return "index";
    }
}
