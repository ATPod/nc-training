package by.training.nc.dev5.clinic.commands.impl.user;

import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;
import by.training.nc.dev5.clinic.services.impl.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class LoginUserCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        String page;
        try {
            if(UserService.getInstance().isAuthorized(login, password)){
                HttpSession session = request.getSession();
                User user = UserService.getInstance().getByLogin(login);
                UserType userType = UserService.getInstance().checkAccessLevel(login);
                session.setAttribute(Parameters.USERTYPE, userType);
                session.setAttribute(Parameters.USER, user);
                List<Patient> list = PatientService.getInstance().getAll();
                session.setAttribute(Parameters.PATIENTS_LIST, list);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PATIENTS_PAGE);
            }
            else{
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
            }
        }
        catch (DAOException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
