package by.training.nc.dev5.web.command;

import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikita on 18.04.2017.
 */
public class LoginCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) {
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
            return loginPage;
        }

        user = authSvc.logOn(login, password);

        if (user == null) {
            request.setAttribute("loginErrorMessage", "Authentication failed");

            return loginPage;
        }

        request.getSession().setAttribute("user", user);

        Object desiredUri = request.getAttribute("desiredUri");

        if (desiredUri != null) {
            return desiredUri.toString();
        }

        return new GoHomeCommand().execute(request, response);
    }
}
