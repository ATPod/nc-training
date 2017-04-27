package by.training.nc.dev5.web.command;

import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 24.04.2017.
 */
public class LogoutCommand implements Command {
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");

        return ConfigurationManager.getInstance().getString("path.page.index");
    }
}
