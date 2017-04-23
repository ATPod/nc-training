package by.training.nc.dev5.clinic.commands.user;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by user on 05.04.2017.
 */
public class RegistrationCommand extends AbstractCommand {
    private static String login;
    private static String password;
    private static String accessLevel;

    public String execute(HttpServletRequest request) {
        String page;
        login = request.getParameter(Parameters.LOGIN);
        password = request.getParameter(Parameters.PASSWORD);
        accessLevel = request.getParameter(Parameters.ACCESS_LEVEL);
        try{
            if(areFieldsFullStocked()){
                if(UserService.isNewUser(login)){
                    if(accessLevelIsCorrect(accessLevel) ) {
                        registrate();
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                    }else{
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ACCESS_LEVEL));
                    }
                }
                else{
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXISTS));
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
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
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
        user.setAccessLevel(accessLevel);
        UserService.add(user);
    }

    private boolean areFieldsFullStocked(){
        boolean isFullStocked = false;
        if(!login.isEmpty() & !password.isEmpty() & !(accessLevel==null) ){
            isFullStocked = true;
        }
        return isFullStocked;
    }

    private boolean accessLevelIsCorrect(String accessLevel){
        boolean isCorrect = false;
        if(accessLevel.equals(AccessLevels.DOCTOR) || accessLevel.equals(AccessLevels.NURSE)){
            isCorrect = true;
        }
        return isCorrect;
    }
}
