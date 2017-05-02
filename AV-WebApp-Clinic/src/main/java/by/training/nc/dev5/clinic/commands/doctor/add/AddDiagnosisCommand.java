package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.entities.Diagnosis;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.DiagnosisService;
import by.training.nc.dev5.clinic.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddDiagnosisCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.DIAGNOSIS_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<=ConfigsConstants.MAX_STRING_LENGTH) {
                    Diagnosis diagnosis = new Diagnosis();
                    Patient patient = PatientService.getById(patientId);
                    diagnosis.setName(name);
                    diagnosis.setPatient(patient);
                    DiagnosisService.add(diagnosis);
                    List<Diagnosis> list = DiagnosisService.getByPatient(patient);
                    session.setAttribute(Parameters.DIAGNOSIS_LIST, list);
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.TOO_LONG_STRING));
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_DIAGNOSIS);
                }
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_DIAGNOSIS);
            }
        }catch (DAOException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
