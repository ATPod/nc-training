package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 26.04.2017.
 */
public class GoCreateTorCommand implements Command {
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getInstance()
                .getString("path.page.customer.createTor");
    }
}
