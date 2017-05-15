package by.training.nc.dev5.web.command;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ManagerDto;
import by.training.nc.dev5.dto.PersonDto;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.service.AuthenticationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 03.05.2017.
 */
public class SignUpCommand implements Command {
    private AuthenticationService authenticationService;

    {
        authenticationService = new AuthenticationServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String role = request.getParameter("userRole");
        PersonDto newUser = new PersonDto(UserRole.valueOf(role));

        newUser.setName(name);

        authenticationService.addPerson(newUser, login, password);
    }
}
