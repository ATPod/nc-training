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

        if (location.equals("home")) {
            Person user = (Person) request.getSession().getAttribute("user");

            location = resolveHome(user);
        } else {
            location = "path.page." + location;
        }

        Router.forward(request, response, location);
    }

    private String resolveHome(Person user) {
        if (user == null) {
            return "path.page.index";
        }

        if (UserRole.CUSTOMER.equals(user.getUserRole())) {
            return "path.page.customer.main";
        } else if (UserRole.MANAGER.equals(user.getUserRole())) {
            return "path.page.manager.main";
        } else if (UserRole.DEVELOPER.equals(user.getUserRole())) {
            return "path.page.developer.main";
        } else {
            return "path.page.index";
        }
    }
}
