package by.training.nc.dev5.clinic.commands.user;

import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impls.UserService;

import javax.servlet.http.HttpServletRequest;

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
                if(login.length()<=ConfigsConstants.MAX_STRING_LENGTH && password.length()<=ConfigsConstants.MAX_STRING_LENGTH && accessLevel.length()<=ConfigsConstants.MAX_STRING_LENGTH) {
                    if (UserService.isNewUser(login)) {
                        if (accessLevelIsCorrect(accessLevel)) {
                            User user = new User();
                            user.setLogin(login);
                            user.setPassword(password);
                            user.setAccessLevel(accessLevel);
                            UserService.add(user);
                            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                        } else {
                            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ACCESS_LEVEL));
                        }
                    } else {
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXISTS));
                    }
                }else{
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.TOO_LONG_STRING));
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                }
            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
            }
        } catch (DAOException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        } catch (NumberFormatException e) {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        } catch(NullPointerException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        }
        return page;
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
