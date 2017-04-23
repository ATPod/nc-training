package by.training.nc.dev5.command.user;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.registration");
    }
}
