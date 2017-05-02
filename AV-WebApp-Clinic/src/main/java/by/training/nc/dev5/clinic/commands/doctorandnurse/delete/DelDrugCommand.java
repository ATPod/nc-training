package by.training.nc.dev5.clinic.commands.doctorandnurse.delete;

import by.training.nc.dev5.clinic.entities.Drug;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.exceptions.DAOException;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.DrugService;
import by.training.nc.dev5.clinic.services.PatientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by user on 12.04.2017.
 */
public class DelDrugCommand extends AbstractCommand {

    public String execute(HttpServletRequest request) {
        String page;
        String id = request.getParameter(Parameters.DRUG_ID);
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        try {
            if (userType == UserType.DOCTOR || userType == UserType.NURSE) {
                if (id != null) {
                    DrugService.delete(Integer.valueOf(id));
                    Patient patient = PatientService.getById(Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID)));
                    List<Drug> list = DrugService.getByPatient(patient);
                    session.setAttribute(Parameters.DRUGS_LIST, list);
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