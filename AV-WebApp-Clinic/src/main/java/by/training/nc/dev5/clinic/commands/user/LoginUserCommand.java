package by.training.nc.dev5.clinic.commands.user;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.UserMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


public class LoginUserCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        String page = null;

        try {
            if(UserMySQLDAO.INSTANCE.isAuthorized(login, password)){
                HttpSession session = request.getSession();
                User user = UserMySQLDAO.INSTANCE.getByLogin(login);
                UserType userType = UserMySQLDAO.INSTANCE.checkAccessLevel(login);
                session.setAttribute(Parameters.USERTYPE, userType);
                session.setAttribute(Parameters.USER, user);
                if(UserType.DOCTOR.equals(userType)){
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_PAGE_PATH);
                }
                else{
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.NURSE_PAGE_PATH);
                }
            }
            else{
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
            }
        }
        catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
