package by.training.nc.dev5.clinic.commands.doctor.delete;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Surgery;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.SurgeryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class DelSurgeryCommand extends AbstractCommand {
    private static int id;
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        id = Integer.valueOf(request.getParameter(Parameters.SURGERY_ID));
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR) {
            SurgeryService.delete(id);
            List<Surgery> list = SurgeryService.getByPatientId(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
            session.setAttribute(Parameters.SURGERIES_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_SURGERIES_PAGE);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        }else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}
