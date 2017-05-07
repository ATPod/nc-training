package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Nikita on 24.04.2017.
 */
public class RemoveTaskCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        String[] tasks = request.getParameterValues("task");
        TermsOfReferenceBuilder torBuilder =
                (TermsOfReferenceBuilder) request.getSession()
                        .getAttribute("torBuilder");
        int[] taskIndexes = new int[tasks.length];

        for (int i = 0; i < taskIndexes.length; i++) {
            taskIndexes[i] = Integer.parseInt(tasks[i]);
        }

        Arrays.sort(taskIndexes);

        for (int i = taskIndexes.length - 1; i >= 0; i--) {
            torBuilder.removeTask(taskIndexes[i]);
        }

        Router.getInstance().redirect(request, response, "path.page.customer.createTor");
    }
}
