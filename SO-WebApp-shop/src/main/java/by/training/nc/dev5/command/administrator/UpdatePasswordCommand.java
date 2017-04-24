package by.training.nc.dev5.command.administrator;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.command.administrator.goTo.GoToSettingsCommand;
import by.training.nc.dev5.constants.Parameters;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.AdministratorService;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;

public class UpdatePasswordCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String password = request.getParameter(Parameters.PASSWORD);
        int adminId = (int) (request.getSession().getAttribute(Parameters.ID_ADMIN));

        try {
            AdministratorService.updateAdministratorPassword(adminId, password);
            page = new GoToSettingsCommand().execute(request);
        } catch (NotFoundException | DAOException e) {
            request.setAttribute(Parameters.ERROR, MessageManager.getProperty("message.server_error"));
            page = ConfigurationManager.getProperty("path.page.admin_settings");
        }

        return page;
    }
}