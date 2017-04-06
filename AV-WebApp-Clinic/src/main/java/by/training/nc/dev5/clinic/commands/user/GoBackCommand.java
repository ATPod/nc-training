package by.training.nc.dev5.clinic.commands.user;

import by.training.nc.dev5.clinic.commands.AbstractCommand;
import by.training.nc.dev5.clinic.constants.ConfigsConstants;
import by.training.nc.dev5.clinic.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by user on 06.04.2017.
 */
public class GoBackCommand extends AbstractCommand {
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        return page;
    }
}
