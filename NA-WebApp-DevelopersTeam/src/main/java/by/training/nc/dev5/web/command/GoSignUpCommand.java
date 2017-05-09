package by.training.nc.dev5.web.command;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 09.05.2017.
 */
public class GoSignUpCommand implements Command {
    private AuthenticationService authenticationService;

    {
        authenticationService = new AuthenticationServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        UserRole[] roles = authenticationService.getSupportedRoles();

        request.setAttribute("roles", roles);
    }
}
