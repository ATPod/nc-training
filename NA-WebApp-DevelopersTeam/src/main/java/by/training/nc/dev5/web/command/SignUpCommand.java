package by.training.nc.dev5.web.command;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 03.05.2017.
 */
public class SignUpCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        Person newUser;
        AuthenticationService authenticationService = (AuthenticationService)
                request.getSession().getServletContext()
                .getAttribute("authenticationService");
        UserRole userRole = UserRole.valueOf(
                UserRole.class,
                request.getParameter("userRole"));

        // TODO: 03.05.2017
    }
}
