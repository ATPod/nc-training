package by.training.nc.dev5.web.command;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 27.04.2017.
 */
public class GoCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String location = request.getParameter("location");

        if (location == null) {
            location = "home";
        }

        if (!"home".equals(location)) {
            if (!location.startsWith("path.page.")) {
                location = "path.page." + location;
            }
        }

        Router.getInstance().forward(request, response, location);
    }
}
