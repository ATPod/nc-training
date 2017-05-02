package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.service.HelpService;
import by.training.nc.dev5.service.TaskBuilder;
import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 19.04.2017.
 */
public class AddTaskCommand implements Command {
    private HelpService helpService;

    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        helpService = (HelpService) request.getSession()
                .getServletContext().getAttribute("helpService");

        TaskBuilder taskBuilder = new TaskBuilder();
        String specification = request.getParameter("specification");
        String developersNumber = request.getParameter("developersNumber");
        TermsOfReferenceBuilder torBuilder = fetchTorBuilder(request);
        Qualification qualification = fetchQualification(request);

        taskBuilder.setSpecification(specification);
        taskBuilder.setDevelopersNumber(qualification,
                                        Integer.parseInt(developersNumber));
        torBuilder.addTask(taskBuilder.createTask());

        Router.redirect(response, "path.page.customer.createTor");
    }

    private TermsOfReferenceBuilder fetchTorBuilder(HttpServletRequest request) {
        return (TermsOfReferenceBuilder) request.getSession()
                .getAttribute("torBuilder");
    }

    private Qualification fetchQualification(HttpServletRequest request) {
        String qualificationId = request.getParameter("qualificationId");

        return helpService.getQualification(
                Integer.parseInt(qualificationId));
    }
}
