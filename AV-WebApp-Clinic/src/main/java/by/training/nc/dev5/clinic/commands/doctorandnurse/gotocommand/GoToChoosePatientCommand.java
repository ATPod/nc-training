package by.training.nc.dev5.clinic.commands.doctorandnurse.gotocommand;

import by.training.nc.dev5.clinic.beans.patient.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.PatientMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.services.PatientService;

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
        if(userType == UserType.DOCTOR || userType == UserType.NURSE){
            List<Patient> list = PatientService.getAll();
            session.setAttribute(Parameters.PATIENTS_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PATIENTS_PAGE);
        } else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
