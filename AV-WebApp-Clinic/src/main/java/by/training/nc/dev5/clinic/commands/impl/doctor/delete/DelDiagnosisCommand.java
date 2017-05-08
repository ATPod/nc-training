package by.training.nc.dev5.clinic.commands.impl.doctor.delete;

import by.training.nc.dev5.clinic.entities.prescribings.Diagnosis;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.DiagnosisService;
import by.training.nc.dev5.clinic.services.impl.PatientService;

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
        try {
            if (userType == UserType.DOCTOR) {
                if (id != null) {
                    DiagnosisService.getInstance().delete(Integer.valueOf(id));
                    Patient patient = PatientService.getInstance().getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Diagnosis> list = DiagnosisService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_CHOICE));
                }
                page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
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