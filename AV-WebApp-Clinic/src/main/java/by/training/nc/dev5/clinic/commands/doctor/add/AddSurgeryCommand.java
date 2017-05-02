package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.Surgery;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.PatientService;
import by.training.nc.dev5.clinic.services.SurgeryService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddSurgeryCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.SURGERY_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<=ConfigsConstants.MAX_STRING_LENGTH) {
                    Surgery surgery = new Surgery();
                    Patient patient = PatientService.getById(patientId);
                    surgery.setName(name);
                    surgery.setPatient(patient);
                    SurgeryService.add(surgery);
                    List<Surgery> list = SurgeryService.getByPatient(patient);
                    session.setAttribute(Parameters.SURGERIES_LIST, list);
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.TOO_LONG_STRING));
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_SURGERY);
                }
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_SURGERY);
            }
        }catch (DAOException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
