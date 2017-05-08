package by.training.nc.dev5.clinic.commands.impl.doctor.gotocommand;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.PagePathManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 12.04.2017.
 */
public class GoToAddDiagnosisCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_DIAGNOSIS);
        }
        else{
            page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
            session.invalidate();
        }
        return page;
    }
}
