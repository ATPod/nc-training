package by.training.nc.dev5.clinic.commands.doctor.delete;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.DiagnosisMySQLDAO;
import by.training.nc.dev5.clinic.dao.SurgeryMySQLDAO;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by user on 12.04.2017.
 */
public class DelSurgeryCommand extends AbstractCommand {
    private static int id;
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        id = Integer.valueOf(request.getParameter(Parameters.SURGERY_ID));
        SurgeryMySQLDAO.INSTANCE.delete(id);
        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.SHOW_SURGERIES_PAGE);
        request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
        return page;
    }
}
