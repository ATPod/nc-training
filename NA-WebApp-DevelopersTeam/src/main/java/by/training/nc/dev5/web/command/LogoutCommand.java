package by.training.nc.dev5.web.command;

import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikita on 24.04.2017.
 */
public class LogoutCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("user");

        return ConfigurationManager.getInstance().getString("path.page.index");
    }
}
