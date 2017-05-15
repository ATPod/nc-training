package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.ServiceException;
import by.training.nc.dev5.service.ManagerService;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 03.05.2017.
 */
public class CreateProjectCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String torId = request.getParameter("torId");
        ManagerService managerService = (ManagerService) request.getSession()
                .getServletContext().getAttribute("managerService");
        TermsOfReference tor;
        Project project;
        Manager user = (Manager) request.getSession().getAttribute("user");

        try {
            tor = managerService.getTermsOfReference(Integer.parseInt(torId));
            project = managerService.applyTermsOfReference(user, tor);

            request.getSession().setAttribute("project", project);

            Router.getInstance().redirect(request, response,
                    "path.page.manager.assignDevelopers");
        } catch (ServiceException e) {
            Router.getInstance().forward(request, response, "path.page.error.internal");
        }
    }
}
