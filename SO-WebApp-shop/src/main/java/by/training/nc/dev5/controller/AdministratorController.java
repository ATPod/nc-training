package by.training.nc.dev5.controller;

import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IAdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user", "bag"})
public class AdministratorController {

    @Autowired
    @Qualifier("AdministratorService")
    IAdministratorService administratorService;

    @RequestMapping(value = {"/admin/update_password"}, method = RequestMethod.POST)
    protected String update(@RequestParam("password") String password,
                            @ModelAttribute("user")Administrator administrator,
                            ModelMap modelMap) {
        try {
            administratorService.updateAdministratorPassword(administrator.getId(), password);
        } catch (NotFoundException | DaoException e) {
            return "error";
        }

        return "redirect:/admin/settings";
    }
}
