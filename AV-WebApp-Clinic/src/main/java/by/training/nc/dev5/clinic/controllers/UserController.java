package by.training.nc.dev5.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * Created by user on 07.05.2017.
 */
@Controller
public class UserController {
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showHomePage(){
        return "index";
    }
}
