package by.training.nc.dev5.clinic.commands.impl.doctor.add;

import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;
import by.training.nc.dev5.clinic.services.impl.MedProcedureService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddMedProcedureCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.MEDPROCEDURE_NAME);
        int patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try {
            if (!name.isEmpty()) {
                if(name.length()<=ConfigsConstants.MAX_STRING_LENGTH) {
                    MedProcedure medProcedure = new MedProcedure();
                    Patient patient = PatientService.getInstance().getById(patientId);
                    medProcedure.setName(name);
                    medProcedure.setPatient(patient);
                    MedProcedureService.getInstance().add(medProcedure);
                    List<MedProcedure> list = MedProcedureService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                }else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.TOO_LONG_STRING));
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_MEDPROCEDURE);
                }
            } else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_MEDPROCEDURE);
            }
        }catch (DAOException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

}
