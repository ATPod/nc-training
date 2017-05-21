package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.dto.ManagerDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.service.ProjectService;
import by.training.nc.dev5.service.ProjectServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public class GoShowProjectsCommand implements Command {
    private ProjectService projectService;
    private Router router;

    {
        router = Router.getInstance();
        projectService = new ProjectServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        ManagerDto user = (ManagerDto) request.getSession()
                .getAttribute("user");
        Collection<ProjectDto> projectsByManager = projectService
                .getProjectsByManager(user);

        request.setAttribute("projectsByManager", projectsByManager);

        router.forward(request, response, "path.page.manager.showMyProjects");
    }
}
