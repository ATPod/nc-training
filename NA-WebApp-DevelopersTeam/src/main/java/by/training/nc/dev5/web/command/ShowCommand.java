package by.training.nc.dev5.web.command;

import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 04.05.2017.
 */
public class ShowCommand extends Router implements Command {

    private Router router;

    {
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String view = request.getParameter("view");

        request.setAttribute("view", router.resolvePath(view));

        router.forward(request, response, "home");
    }
}
