package by.training.nc.dev5.web.command;

import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 26.04.2017.
 */
public class GoLoginCommand implements Command {
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getInstance()
                .getString("path.page.login");
    }
}
