package by.training.nc.dev5.clinic.commands.doctor.add;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;
import by.training.nc.dev5.clinic.services.ProcedureService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;


public class AddProcedureCommand extends AbstractCommand {
    private static String name;
    private static int patientId;
    public String execute(HttpServletRequest request) {
        String page;
        HttpSession session = request.getSession();
        name = request.getParameter(Parameters.PROCEDURE_NAME);
        patientId = Integer.valueOf((String) session.getAttribute(Parameters.PATIENT_ID));
        try{
            if(!name.isEmpty()){
                add();
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_MENU);
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
            } else{
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DOCTOR_ADD_PROCEDURE);
            }

        }catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        return page;
    }

    private void add() throws SQLException{

        Procedure procedure = new Procedure();
        procedure.setName(name);
        procedure.setPatientId(patientId);
        ProcedureService.add(procedure);
    }
}
