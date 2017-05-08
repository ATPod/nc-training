package by.training.nc.dev5.clinic.commands.impl.doctor.add;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.Surgery;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;
import by.training.nc.dev5.clinic.services.impl.SurgeryService;
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
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    Surgery surgery = new Surgery();
                    Patient patient = PatientService.getInstance().getById(patientId);
                    surgery.setName(name);
                    surgery.setPatient(patient);
                    SurgeryService.getInstance().add(surgery);
                    List<Surgery> list = SurgeryService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.SURGERIES_LIST, list);
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_MENU);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_SURGERY);
                }
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_SURGERY);
            }
        }catch (DAOException e){
            page = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
