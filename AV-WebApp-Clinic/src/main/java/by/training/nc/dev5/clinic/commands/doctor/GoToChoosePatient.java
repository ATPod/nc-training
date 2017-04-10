package by.training.nc.dev5.clinic.commands.doctor;

import by.training.nc.dev5.clinic.beans.User;
import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.constants.MessageConstants;
import by.training.nc.dev5.clinic.constants.Parameters;
import by.training.nc.dev5.clinic.dao.UserMySQLDAO;
import by.training.nc.dev5.clinic.filters.UserType;
import by.training.nc.dev5.clinic.logger.ClinicLogger;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
/*public class GoToChoosePatient extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        UserType userType = (UserType)session.getAttribute(Parameters.USERTYPE);
        if(userType == UserType.DOCTOR){
            try{
                List<User> list = UserMySQLDAO.INSTANCE.findAll();
                session.setAttribute(Parameters.USER_LIST, list);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SHOW_CLIENTS_PAGE);
            }
            catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
                request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
            }
        }
        else{
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            session.invalidate();
        }
        return page;
    }
}*/
