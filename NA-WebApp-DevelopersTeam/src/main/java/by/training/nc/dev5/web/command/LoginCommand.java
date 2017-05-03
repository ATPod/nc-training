package by.training.nc.dev5.web.command;

import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.service.AuthenticationService;
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

//        AuthenticationService authenticationService = (AuthenticationService)
//                request.getSession().getServletContext()
//                        .getAttribute("authenticationService");
        AuthenticationService authenticationService = AuthenticationService.getInstance();
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        Person user;

        if (login == null || password == null) {
            request.setAttribute(
                    "loginErrorMessage", "No login/password provided");
            Router.forward(request, response, "login");
        }

        user = authenticationService.logOn(login, password);

        if (user == null) {
            request.setAttribute("loginErrorMessage", "Authentication failed");

            Router.forward(request, response, "login");
        }

        request.getSession().setAttribute("user", user);

        Object desiredUri = request.getAttribute("desiredUri");

        if (desiredUri != null) {
            Router.redirect(request, response, desiredUri.toString());
        }

        Router.redirect(request, response, "controller?command=go&location=home");
    }
}
