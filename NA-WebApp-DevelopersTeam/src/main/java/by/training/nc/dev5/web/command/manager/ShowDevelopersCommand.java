package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.exception.ServiceException;
import by.training.nc.dev5.service.HelpService;
import by.training.nc.dev5.service.ManagerService;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 02.05.2017.
 */
public class ShowDevelopersCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        ManagerService managerService = (ManagerService) request.getSession()
                .getServletContext().getAttribute("managerService");
        HelpService helpService = (HelpService) request.getSession()
                .getServletContext().getAttribute("helpService");
        String qualificationId = request.getParameter("qualificationId");
        Collection<Developer> unassignedDevelopers;

        try {
            unassignedDevelopers = managerService.getUnassignedDevelopers(
                    Integer.parseInt(qualificationId));

            request.setAttribute("unassignedDevelopers", unassignedDevelopers);

            Router.forward(request,
                           response,
                           "path.page.manager.assignDevelopers");
        } catch (ServiceException e) {
            Router.forward(request, response, "path.page.error.internal");
        }
    }
}
