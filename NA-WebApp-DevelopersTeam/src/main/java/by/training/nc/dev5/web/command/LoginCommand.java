package by.training.nc.dev5.web.command;

import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 18.04.2017.
 */
public class LoginCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AuthenticationService authSvc =
                AuthenticationService.getInstance();
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        Person user;
        String loginPage = ConfigurationManager.getInstance()
                .getString("path.page.login");

        if (login == null || password == null) {
            request.setAttribute(
                    "loginErrorMessage", "No login/password provided");
            Router.forward(request, response, loginPage);
        }

        user = authSvc.logOn(login, password);

        if (user == null) {
            request.setAttribute("loginErrorMessage", "Authentication failed");

            Router.forward(request, response, loginPage);
        }

        request.getSession().setAttribute("user", user);

        Object desiredUri = request.getAttribute("desiredUri");

        if (desiredUri != null) {
            Router.forward(request, response, desiredUri.toString());
        }

        Router.forward(request, response, "home");
    }
}
