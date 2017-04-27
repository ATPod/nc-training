package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikita on 26.04.2017.
 */
public class ShowMyTorsCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        return ConfigurationManager.getInstance()
                .getString("path.page.customer.showTors");
    }
}
