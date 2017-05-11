package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.ServiceException;
import by.training.nc.dev5.service.*;
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
    private final Router router;
    private ProjectService projectService;

    {
        projectService = new ProjectServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String[] developerIds = request.getParameterValues("developerId");
        Collection<DeveloperDto> developers =
                new ArrayList<DeveloperDto>(developerIds.length);
        ProjectDto project;

        project = new ProjectDto();
        project.setId(Integer.parseInt(request.getParameter("projectId")));

        for (String developerId : developerIds) {
            int devId = Integer.parseInt(developerId);
            DeveloperDto developerDto = new DeveloperDto();

            developerDto.setId(devId);

            developers.add(developerDto);
        }

        projectService.assignDevelopers(project, developers);

        router.redirect(request, response, "home");
    }
}
