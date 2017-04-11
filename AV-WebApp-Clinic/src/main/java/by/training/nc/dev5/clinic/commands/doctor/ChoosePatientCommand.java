package by.training.nc.dev5.clinic.commands.doctor;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 11.04.2017.
 */
public class ChoosePatientCommand extends AbstractCommand {

    @SuppressWarnings("rawtypes")
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            if(request.getParameter(Parameters.PATIENT_ID) != null){
                session.setAttribute(Parameters.PATIENT_ID, request.getParameter(Parameters.PATIENT_ID));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_INNER_MENU);
            }
            else if(!((List)session.getAttribute(Parameters.PATIENTS_LIST)).isEmpty()){
                request.setAttribute(Parameters.ERROR_EMPTY_CHOICE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_CHOICE));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_SHOW_PATIENTS_PAGE);
            }
            else{
                request.setAttribute(Parameters.ERROR_EMPTY_LIST, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_LIST));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_SHOW_PATIENTS_PAGE);
            }
        }
        else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
