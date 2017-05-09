package by.training.nc.dev5.clinic.commands.impl.doctorandnurse.goback;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.PagePathManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 11.04.2017.
 */
public class GoBackToChoosePatientCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR || userType == UserType.NURSE){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
        } else{
            page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
