package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.service.*;
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
public class GoShowAssignDevelopersCommand implements Command {
    private final Router router;
    private ProjectService projectService;
    private DeveloperService developerService;
    private QualificationService qualificationService;

    {
        qualificationService = new QualificationServiceImpl();
        developerService = new DeveloperServiceImpl();
        projectService = new ProjectServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        ManagerDto user = (ManagerDto) request.getSession()
                .getAttribute("user");
        Collection<ProjectDto> projectsByManager = projectService
                .getProjectsByManager(user);
        String qualificationId = request.getParameter("qualificationId");
        Collection<QualificationDto> qualifications =
                qualificationService.getQualifications();
        Collection<DeveloperDto> unassignedDevelopers;

        request.setAttribute("qualifications", qualifications);
        request.setAttribute("projectsByManager", projectsByManager);

        if (qualificationId != null) {
            int qId = Integer.parseInt(qualificationId);
            QualificationDto qualificationDto = new QualificationDto();

            qualificationDto.setId(qId);

            unassignedDevelopers = developerService
                    .getUnassignedDevelopers(qualificationDto);

        } else {
            unassignedDevelopers = developerService.getUnassignedDevelopers();
        }

        request.setAttribute("unassignedDevelopers",
                unassignedDevelopers);

        router.forward(request, response,
                "path.page.manager.assignDevelopers");
    }
}
