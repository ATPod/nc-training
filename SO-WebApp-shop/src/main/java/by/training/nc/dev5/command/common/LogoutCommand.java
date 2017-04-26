package by.training.nc.dev5.command.common;
import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager. getProperty("path.page.index");
        request.getSession().invalidate();
        return page;
    }
}