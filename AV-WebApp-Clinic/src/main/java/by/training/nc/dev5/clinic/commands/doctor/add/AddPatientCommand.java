package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.beans.patient.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class AddPatientCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        String name = request.getParameter(Parameters.PATIENT_NAME);
        try{
            if(!name.isEmpty()){
                if(PatientService.isNewPatient(name)){
                    Patient patient = new Patient();
                    patient.setName(name);
                    PatientService.add(patient);
                    List<Patient> list = PatientService.getAll();
                    session.setAttribute(Parameters.PATIENTS_LIST, list);
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_PATIENTS_PAGE);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                }else{
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PATIENT);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.PATIENT_EXISTS));
                }
            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PATIENT);
            }
        }catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}
