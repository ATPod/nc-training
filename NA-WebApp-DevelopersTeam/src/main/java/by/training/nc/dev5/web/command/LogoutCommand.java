package by.training.nc.dev5.web.command;

import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 24.04.2017.
 */
public class LogoutCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("user");

        Router.forward(request, response, "path.page.index");
    }
}
