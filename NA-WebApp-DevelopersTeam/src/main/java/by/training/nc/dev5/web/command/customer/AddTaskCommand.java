package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.dto.TaskDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.service.*;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nikita on 19.04.2017.
 */
public class AddTaskCommand implements Command {
    private Router router;
    private QualificationService qualificationService;

    {
        qualificationService = new QualificationServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        TermsOfReferenceDto termsDto = fetchTermsDto(request);

        termsDto.getTasks().add(fetchTaskDto(request));

        String uri = "controller?command=goCreateTerms";

        router.redirect(request, response, uri);
    }

    private TermsOfReferenceDto fetchTermsDto(HttpServletRequest request) {
        TermsOfReferenceDto dto = (TermsOfReferenceDto) request.getSession()
                .getAttribute("createdTerms");

        if (dto == null) {
            dto = new TermsOfReferenceDto();
            dto.setTasks(new ArrayList<TaskDto>());
            request.getSession().setAttribute("createdTerms", dto);
        }

        return dto;
    }

    private TaskDto fetchTaskDto(HttpServletRequest request) {
        String specification = request.getParameter("specification");
        int developersNumber = Integer.parseInt(
                request.getParameter("developersNumber"));
        int qualificationId = Integer.parseInt(
                request.getParameter("qualificationId"));
        TaskDto taskDto = new TaskDto();
        QualificationDto q;

        taskDto.setQuotas(new HashMap<QualificationDto, Integer>());

        q = qualificationService.getQualification(qualificationId);

        taskDto.getQuotas().put(q, developersNumber);
        taskDto.setSpecification(specification);

        return taskDto;
    }
}
