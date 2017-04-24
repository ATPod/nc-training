package by.training.nc.dev5.clinic.commands.doctor.delete;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.DiagnosisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class DelDiagnosisCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        String id = request.getParameter(Parameters.DIAGNOSIS_ID);
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if (userType == UserType.DOCTOR) {
            if(id != null) {
                DiagnosisService.delete(Integer.valueOf(id));
                List<Diagnosis> list = DiagnosisService.getByPatientId(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
            }else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_CHOICE));
            }
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
        } else {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}