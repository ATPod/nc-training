package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.service.CustomerService;
import by.training.nc.dev5.service.TaskBuilder;
import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikita on 19.04.2017.
 */
public class AddTaskCommand implements Command {
    private CustomerService customerService = new CustomerService();

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String currentPage = ConfigurationManager.getInstance()
                .getString("path.page.customer.createTor");
        TaskBuilder taskBuilder = new TaskBuilder();
        String specification = request.getParameter("specification");
        String developersNumber = request.getParameter("developersNumber");
        TermsOfReferenceBuilder torBuilder = fetchTorBuilder(request);
        Qualification qualification = fetchQualification(request);

        taskBuilder.setSpecification(specification);
        taskBuilder.setDevelopersNumber(qualification,
                                        Integer.parseInt(developersNumber));
        torBuilder.addTask(taskBuilder.createTask());

        return currentPage;
    }

    private TermsOfReferenceBuilder fetchTorBuilder(HttpServletRequest request) {
        return (TermsOfReferenceBuilder) request.getSession()
                .getAttribute("torBuilder");
    }

    private Qualification fetchQualification(HttpServletRequest request) {
        String qualificationId = request.getParameter("qualificationId");

        return customerService.getQualification(
                Integer.parseInt(qualificationId));
    }
}
