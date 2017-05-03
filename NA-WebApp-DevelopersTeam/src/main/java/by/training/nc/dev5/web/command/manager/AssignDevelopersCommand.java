package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.ServiceException;
import by.training.nc.dev5.service.ManagerService;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 03.05.2017.
 */
public class AssignDevelopersCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        ManagerService managerService = (ManagerService) request.getSession()
                .getServletContext().getAttribute("managerService");
        String[] developerIds = request.getParameterValues("developerId");
        Collection<Developer> developers =
                new ArrayList<Developer>(developerIds.length);
        Project project;

        try {
            project = managerService.getProject(
                    Integer.parseInt(request.getParameter("projectId")));
            for (String developerId : developerIds) {
                developers.add(managerService.getDeveloper(
                        Integer.parseInt(developerId)));
            }

            managerService.assignDevelopers(project, developers);

            Router.getInstance().redirect(request, response, "home");
        } catch (ServiceException e) {
            Router.getInstance().forward(request, response, "path.page.error.internal");
        }
    }
}
