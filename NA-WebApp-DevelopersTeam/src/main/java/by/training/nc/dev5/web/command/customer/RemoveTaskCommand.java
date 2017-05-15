package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Nikita on 24.04.2017.
 */
public class RemoveTaskCommand implements Command {

    private Router router;

    {
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException, ServletException {

        // TODO
        router.forward(request, response, "home");
    }
}
