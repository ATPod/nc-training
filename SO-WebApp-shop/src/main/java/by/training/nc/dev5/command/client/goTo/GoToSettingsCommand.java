package by.training.nc.dev5.command.client.goTo;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GoToSettingsCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = ConfigurationManager.getProperty("path.page.client_settings");

        if ((byte)request.getSession().getAttribute(Parameters.BLACK_LIST) == 1){
            request.setAttribute(Parameters.BLACK_LIST_MSG,  MessageManager.getProperty("message.black_list"));
        }
        else {
            request.setAttribute(Parameters.BLACK_LIST_MSG, "");
        }

        return page;
    }
}