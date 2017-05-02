package by.training.nc.dev5.clinic.commands.doctor.delete;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 11.04.2017.
 */
public class DelPatientCommand extends AbstractCommand {
    private static int patientId;

    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        UserType userType = (UserType) session.getAttribute(Parameters.USERTYPE);
        if (userType == UserType.DOCTOR) {
            try {
                PatientService.delete(patientId);
                List<Patient> list = PatientService.getAll();
                session.setAttribute(Parameters.PATIENTS_LIST, list);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PATIENTS_PAGE);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));

            } catch (DAOException e) {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
            }
        }
        return page;
    }
}