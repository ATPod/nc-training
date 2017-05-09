package by.training.nc.dev5.clinic.commands.impl.doctor.add;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.PagePathManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddPatientCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.PATIENT_NAME);
        try{
            if(!name.isEmpty()){
                if(name.length()<= ConfigConstants.MAX_STRING_LENGTH) {
                    if (PatientService.getInstance().isNewPatient(name)) {
                        Patient patient = new Patient();
                        patient.setName(name);
                        PatientService.getInstance().add(patient);
                        List<Patient> list = PatientService.getInstance().getAll();
                        session.setAttribute(Parameters.PATIENTS_LIST, list);
                        page = PagePathManager.getInstance().getProperty(ConfigConstants.SHOW_PATIENTS_PAGE);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.SUCCESS_OPERATION));
                    } else {
                        page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
                        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.PATIENT_EXISTS));
                    }
                }else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.TOO_LONG_STRING));
                    page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
                }
            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.EMPTY_FIELDS));
                page = PagePathManager.getInstance().getProperty(ConfigConstants.DOCTOR_ADD_PATIENT);
            }
        }catch (DAOException e) {
            page = PagePathManager.getInstance().getProperty(ConfigConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.getInstance().getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
