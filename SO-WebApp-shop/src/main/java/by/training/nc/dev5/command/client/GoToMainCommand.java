package by.training.nc.dev5.command.client;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class GoToMainCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.getProperty("path.page.clientmain");
    }
}