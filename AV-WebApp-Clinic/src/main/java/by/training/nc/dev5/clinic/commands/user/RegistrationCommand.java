package by.training.nc.dev5.clinic.commands.user;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.UserDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by user on 05.04.2017.
 */
public class RegistrationCommand extends AbstractCommand {
    private static String login;
    private static String password;
    private static String accessLevelString;

    public String execute(HttpServletRequest request) {
        String page = null;
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        accessLevelString = request.getParameter(Parameters.ACCESS_LEVEL);
        try{
            if(areFieldsFullStocked()){
                int accessLevel = Integer.valueOf(accessLevelString);
                if(isNewUser()){
                    if(accessLevelisCorrect(accessLevel) ) {
                        registrate();
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                    }else{
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.ERROR_ACCESS_LEVEL, MessageManager.INSTANCE.getProperty(MessageConstants.ACCESS_LEVEL));
                    }
                }
                else{
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                    request.setAttribute(Parameters.ERROR_USER_EXISTS, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXISTS));
                }
            }
            else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
            }
        }
        catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        catch (NumberFormatException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        }
        catch(NullPointerException e){
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        }
        return page;
    }

    private void registrate() throws SQLException{

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setAccessLevel(Integer.valueOf(accessLevelString));
        UserDAO.INSTANCE.createEntity(user);
    }

    private boolean areFieldsFullStocked(){
        boolean isFullStocked = false;
        if(!login.isEmpty() & !password.isEmpty() & !accessLevelString.isEmpty() ){
            isFullStocked = true;
        }
        return isFullStocked;
    }

    private boolean isNewUser() throws SQLException{
        boolean isNew = false;
        if(UserDAO.INSTANCE.isNewUser(login)){
            isNew = true;
        }
        return isNew;
    }

    private boolean accessLevelisCorrect(int accessLevel){
        boolean isCorrect = false;
        if(accessLevel==1 || accessLevel==2){
            isCorrect = true;
        }
        return isCorrect;
    }
}
