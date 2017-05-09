package by.training.nc.dev5.clinic.commands.impl.user;

import by.training.nc.dev5.clinic.entities.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.AccessLevels;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.UserService;

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
                if(login.length()<= ConfigConstants.MAX_STRING_LENGTH && password.length()<= ConfigConstants.MAX_STRING_LENGTH && accessLevel.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    if (UserService.getInstance().isNewUser(login)) {
                        if (accessLevelIsCorrect(accessLevel)) {
                            User user = new User();
                            user.setLogin(login);
                            user.setPassword(password);
                            user.setAccessLevel(accessLevel);
                            UserService.getInstance().add(user);
                            page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                        } else {
                            page = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ACCESS_LEVEL));
                        }
                    } else {
                        page = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.USER_EXISTS));
                    }
                }else{
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
                }
            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                page = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
            }
        } catch (DAOException e) {
            page = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        } catch (NumberFormatException e) {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
            page = PagePathManager.getInstance().getProperty(ConfigConstants.REGISTRATION_PAGE_PATH);
        } catch(NullPointerException e){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
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
