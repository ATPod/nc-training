package by.training.nc.dev5.clinic.commands.doctor.gotocommand;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 12.04.2017.
 */
public class GoToAddDiagnosisCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_DIAGNOSIS);
        }
        else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_INNER_MENU);
            session.invalidate();
        }
        return page;
    }
}
