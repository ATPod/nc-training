package by.training.nc.dev5.web.command;

import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 18.04.2017.
 */
public class EmptyCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Router.forward(request, response, "path.page.index");
    }
}
