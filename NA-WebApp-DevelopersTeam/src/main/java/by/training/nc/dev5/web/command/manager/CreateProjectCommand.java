package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 03.05.2017.
 */
public class CreateProjectCommand implements Command {
    private Router router;

    {
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        String uri = "home";

        // TODO
        router.redirect(request, response, uri);
    }
}
