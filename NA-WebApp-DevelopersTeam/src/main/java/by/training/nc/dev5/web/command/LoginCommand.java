package by.training.nc.dev5.web.command;

import by.training.nc.dev5.dto.PersonDto;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.service.AuthenticationServiceImpl;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Nikita on 18.04.2017.
 */
public class LoginCommand implements Command {
    private AuthenticationService authenticationService;
    private Router router;

    {
        authenticationService = new AuthenticationServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("username");
        String password = request.getParameter("password");
        PersonDto user;

        if (login == null || login.length() == 0 ||
                password == null || password.length() == 0) {
            request.setAttribute(
                    "loginErrorMessage", "No login/password provided");
            router.forward(request, response, "login");
            return;
        }

        user = authenticationService.authenticate(login, password);

        if (user == null) {
            request.setAttribute("loginErrorMessage", "Authentication failed");

            router.forward(request, response, "login");
        }

        setSessionAttributes(request.getSession(), user);

        Object desiredUri = request.getAttribute("desiredUri");

        if (desiredUri != null) {
            router.redirect(request, response, desiredUri.toString());
        }

        router.redirect(request, response, "home");
    }

    private void setSessionAttributes(HttpSession session, PersonDto user) {
        session.setAttribute("user", user);
    }
}