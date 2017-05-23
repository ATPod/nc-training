package by.training.nc.dev5.clinic.controllers;

import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.services.IPatientService;
import by.training.nc.dev5.clinic.services.IUserService;
import by.training.nc.dev5.clinic.services.impl.PatientService;
import by.training.nc.dev5.clinic.services.impl.UserService;
import by.training.nc.dev5.clinic.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 07.05.2017.
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IPatientService patientService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndexPage(HttpServletRequest request){
        request.getSession().invalidate();
        HibernateUtil.closeEntityManager();
        return PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = Parameters.LOGIN, required = false) String login,
                        @RequestParam(value = Parameters.PASSWORD, required = false) String password,
                        ModelMap model, HttpServletRequest request) {
        String pagePath;
        try {
            if(userService.isAuthorized(login, password)){
                UserType userType = userService.checkAccessLevel(login);
                request.getSession().setAttribute(Parameters.USERTYPE, userType);
                request.getSession().setAttribute(Parameters.PATIENTS_LIST, patientService.getAll());
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
            } else{
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
            }
        } catch (DAOException e) {
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return pagePath;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(ModelMap model){
        model.put(Parameters.USER, new User());
        return PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrate(@ModelAttribute("user") User user, ModelMap model){
        String pagePath;
        String login = user.getLogin();
        String password = user.getPassword();
        String accessLevel=user.getAccessLevel();
        try{
            if(!login.isEmpty() & !password.isEmpty() & !(accessLevel==null)){
                if(login.length()<= ConfigConstants.MAX_STRING_LENGTH && password.length()<= ConfigConstants.MAX_STRING_LENGTH && accessLevel.length()<= ConfigConstants.MAX_STRING_LENGTH){
                    if (userService.isNewUser(login)){
                        if (accessLevel.equals(AccessLevels.DOCTOR) || accessLevel.equals(AccessLevels.NURSE)) {
                            userService.add(user);
                            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                        }else{
                            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ACCESS_LEVEL));
                        }
                    }else{
                        pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                        model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.USER_EXISTS));
                    }
                }else{
                    model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                }
            }else{
                model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
            }
        }catch (DAOException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            model.put(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }catch(NullPointerException e){
            pagePath = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
        }
        return pagePath;
    }
}