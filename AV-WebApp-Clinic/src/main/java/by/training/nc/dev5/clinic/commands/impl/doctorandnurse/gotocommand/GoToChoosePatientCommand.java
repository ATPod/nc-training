package by.training.nc.dev5.clinic.commands.impl.doctorandnurse.gotocommand;

import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public class GoToChoosePatientCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                List<Patient> list = PatientService.getInstance().getAll();
                session.setAttribute(Parameters.PATIENTS_LIST, list);
                page = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
            } else {
                page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        }catch (DAOException e){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
