package by.training.nc.dev5.clinic.commands.doctor.gotocommand;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 12.04.2017.
 */
public class GoToAddSurgeryCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_SURGERY);
        }
        else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return page;
    }
}
