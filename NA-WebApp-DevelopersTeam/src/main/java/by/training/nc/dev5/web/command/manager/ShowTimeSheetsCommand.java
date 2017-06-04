package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ManagerDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.dto.TimeSheetDto;
import by.training.nc.dev5.service.ProjectService;
import by.training.nc.dev5.service.ProjectServiceImpl;
import by.training.nc.dev5.service.TimeTrackingService;
import by.training.nc.dev5.service.TimeTrackingServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 23.05.2017.
 */
public class ShowTimeSheetsCommand implements Command {
    private TimeTrackingService timeTrackingService;
    private ProjectService projectService;
    private Router router;

    {
        projectService = new ProjectServiceImpl();
        router = Router.getInstance();
        timeTrackingService = new TimeTrackingServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String projectId = request.getParameter("projectId");
        ProjectDto project = new ProjectDto();
        Collection<TimeSheetDto> timeSheets = new ArrayList<TimeSheetDto>();
        ManagerDto user = (ManagerDto) request.getSession()
                .getAttribute("user");
        Collection<ProjectDto> projectsByManager =
                projectService.getProjectsByManager(user);

        request.setAttribute("projectsByManager", projectsByManager);

        if (projectId == null) {
            router.forward(request, response,
                    "path.page.manager.showTimeSheets");
            return;
        }

        project = getProjectById(Integer.parseInt(projectId),
                 projectsByManager);

        if (project == null) {
            router.forward(request, response, "path.page.error.notFound");

            return;
        }

        for (DeveloperDto developer : project.getDevelopers()) {
            timeSheets.addAll(timeTrackingService.getTimeSheets(developer));
        }

        request.setAttribute("timeSheets", timeSheets);

        router.forward(request, response, "path.page.manager.showTimeSheets");
    }

    private ProjectDto getProjectById(int id, Collection<ProjectDto> projects) {
        for (ProjectDto projectDto : projects) {
            if (projectDto.getId() == id) {
                return projectDto;
            }
        }

        return null;
    }
}
