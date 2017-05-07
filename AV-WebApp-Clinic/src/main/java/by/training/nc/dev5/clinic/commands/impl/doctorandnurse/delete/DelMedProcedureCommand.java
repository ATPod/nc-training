package by.training.nc.dev5.clinic.commands.impl.doctorandnurse.delete;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.enums.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.impl.PatientService;
import by.training.nc.dev5.clinic.services.impl.MedProcedureService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class DelMedProcedureCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        String id = request.getParameter(Parameters.MEDPROCEDURE_ID);
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    MedProcedureService.getInstance().delete(Integer.valueOf(id));
                    Patient patient = PatientService.getInstance().getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<MedProcedure> list = MedProcedureService.getInstance().getByPatient(patient);
                    session.setAttribute(Parameters.MEDPROCEDURES_LIST, list);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                } else {
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_CHOICE));
                }
                if (userType == UserType.DOCTOR) {
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
                } else {
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.NURSE_MENU);
                }
            } else {
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        }catch (DAOException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }
}