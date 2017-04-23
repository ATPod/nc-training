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
    private static int id;
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        id = Integer.valueOf(request.getParameter(Parameters.DIAGNOSIS_ID));
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR) {
            DiagnosisService.delete(id);
            List<Diagnosis> list = DiagnosisService.getByPatientId(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
            session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_DIAGNOSISES_PAGE);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        }else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}