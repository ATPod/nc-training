package by.training.nc.dev5.clinic.commands.impl.user;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;
import by.training.nc.dev5.clinic.utils.HibernateUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 05.04.2017.
 */
public class GoBackToLoginCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.getSession().invalidate();
        HibernateUtil.closeEntityManager();
        return page;
    }
}