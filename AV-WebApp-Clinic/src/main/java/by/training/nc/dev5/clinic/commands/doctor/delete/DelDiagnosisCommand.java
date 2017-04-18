package by.training.nc.dev5.clinic.commands.doctor.delete;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.DiagnosisMySQLDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by user on 12.04.2017.
 */
public class DelDiagnosisCommand extends AbstractCommand {
    private static int id;
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        id = Integer.valueOf(request.getParameter(Parameters.DIAGNOSIS_ID));
        DiagnosisMySQLDAO.INSTANCE.delete(id);
        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_DIAGNOSISES_PAGE);
        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        return page;
    }
}
