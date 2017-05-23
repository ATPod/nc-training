package by.training.nc.dev5.controller;

import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.logger.SystemLogger;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.IAdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class AdministratorController {

    @Autowired
    @Qualifier("AdministratorService")
    IAdministratorService administratorService;

    @RequestMapping(value = {"/admin_update_password"}, method = RequestMethod.POST)
    protected String update(@RequestParam(Parameters.PASSWORD) String password,
                            HttpSession session, ModelMap modelMap) {

        int adminId = (int) (session.getAttribute(Parameters.ID_ADMIN));

        try {
            administratorService.updateAdministratorPassword(adminId, password);
        } catch (NotFoundException | DaoException e) {
            SystemLogger.INSTANCE.logError(getClass(), e.getMessage());
            modelMap.addAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
        }

        return JspPaths.ADMIN_SETTINGS;
    }

    @RequestMapping(value = {"/admin_settings"}, method = RequestMethod.GET)
    protected String openSettings(ModelMap modelMap) {
        return JspPaths.ADMIN_SETTINGS;
    }
}
