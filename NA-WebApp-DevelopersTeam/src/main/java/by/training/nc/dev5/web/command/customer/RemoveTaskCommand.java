package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 24.04.2017.
 */
public class RemoveTaskCommand implements Command {
    public String execute(HttpServletRequest request) {
        String currentPage = ConfigurationManager.getInstance()
                .getString("path.page.customer.createTor");
        String[] tasks = request.getParameterValues("task");
        TermsOfReferenceBuilder torBuilder =
                (TermsOfReferenceBuilder) request.getSession()
                        .getAttribute("torBuilder");

        for (String taskId : tasks) {
            torBuilder.removeTask(Integer.parseInt(taskId));
        }

        return currentPage;
    }
}
