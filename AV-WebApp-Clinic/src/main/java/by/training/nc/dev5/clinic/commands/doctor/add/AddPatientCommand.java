package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.beans.patient.Patient;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.PatientMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by user on 11.04.2017.
 */
public class AddPatientCommand extends AbstractCommand {
    private static String name;
    public String execute(HttpServletRequest request) {
        String page = null;
        name = request.getParameter(Parameters.PATIENT_NAME);
        try{
            if(!name.isEmpty()){
                if(isNewPatient()){
                    add();
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PATIENT);
                    request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                }else{
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PATIENT);
                    request.setAttribute(Parameters.ERROR_USER_EXISTS, MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXISTS));
                }

            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PATIENT);
            }

        }catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private void add() throws SQLException{

        Patient temp = new Patient();
        temp.setName(name);
        PatientMySQLDAO.INSTANCE.add(temp);
    }

    private boolean isNewPatient() throws SQLException {
        boolean isNew = false;
        if(PatientMySQLDAO.INSTANCE.isNewPatient(name)){
            isNew = true;
        }
        return isNew;
    }
}
