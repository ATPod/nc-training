package by.training.nc.dev5.controller.navigation;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.entity.UserRoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class CommonNavigationController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.POST, RequestMethod.GET})
    protected String openLogin(Locale locale, @RequestParam(value = "error", defaultValue = "false") boolean error, ModelMap modelMap) {
        if (error == true) {
            modelMap.addAttribute("errorMessage", messageSource.getMessage("msg.loginError", null, locale));
        }
        return JspPaths.LOGIN;
    }

    @RequestMapping(value = "/registration", method = {RequestMethod.GET})
    public String openRegistration(Locale locale, @RequestParam(value = "error", defaultValue = "-1") int error,
                                   ModelMap modelMap) {
        if (error == 0){
            modelMap.addAttribute("errorMessage", messageSource.getMessage("msg.duplicationError", null, locale));
        }

        if (error == 1){
            modelMap.addAttribute("errorMessage", messageSource.getMessage("msg.syntaxError", null, locale));
        }
        return JspPaths.REGISTRATION;
    }

    @RequestMapping(value = {"/error"}, method = RequestMethod.GET)
    protected String openError(ModelMap modelMap) {
        return "error";
    }

    @RequestMapping(value = {"/homepage"}, method = RequestMethod.GET)
    protected String openHomepage(ModelMap modelMap) {
        return "homepage";
    }
}
