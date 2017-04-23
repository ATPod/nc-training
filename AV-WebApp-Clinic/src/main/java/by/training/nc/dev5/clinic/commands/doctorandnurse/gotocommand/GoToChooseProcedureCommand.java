package by.training.nc.dev5.clinic.commands.doctorandnurse.gotocommand;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.services.ProcedureService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 15.04.2017.
 */
public class GoToChooseProcedureCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR || userType == UserType.NURSE){
            List<Procedure> list = ProcedureService.getByPatientId(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
            session.setAttribute(Parameters.PROCEDURES_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PROCEDURES_PAGE);
        }
        else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
