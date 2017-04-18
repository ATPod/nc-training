package by.training.nc.dev5.command.user;

import by.training.nc.dev5.command.ActionCommand;
import by.training.nc.dev5.exceptions.DAOException;
import by.training.nc.dev5.exceptions.DuplicationException;
import by.training.nc.dev5.resource.ConfigurationManager;
import by.training.nc.dev5.resource.MessageManager;
import by.training.nc.dev5.services.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterCommand implements ActionCommand {

    private static final String PARAM_NAME_FIRST_NAME = "firstname";
    private static final String PARAM_NAME_LAST_NAME  = "lastname";
    private static final String PARAM_NAME_EMAIL      = "email";
    private static final String PARAM_NAME_PASSWORD   = "password";

    @Override
    public String execute(HttpServletRequest request) {

        String page = null;

        String firstName = request.getParameter(PARAM_NAME_FIRST_NAME).trim();
        String lastName  = request.getParameter(PARAM_NAME_LAST_NAME).trim();
        String email     = request.getParameter(PARAM_NAME_EMAIL).trim();
        String password  = request.getParameter(PARAM_NAME_PASSWORD).trim();

        Matcher matcherFName = Pattern.compile("^[a-zA-Z]+$").matcher(firstName);
        Matcher matcherLName = Pattern.compile("^[a-zA-Z]+$").matcher(lastName);
        Matcher matcherEmail = Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z").matcher(email);

        if (matcherEmail.matches() && matcherFName.matches() && matcherLName.matches()) {

            try {
                ClientService.addClient(firstName, lastName, email, password);
                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                session.setAttribute("firstname", firstName);
                session.setAttribute("lastname", lastName);

                page = ConfigurationManager.getProperty("path.page.clientmain");
            } catch (DAOException e) {
                request.setAttribute("errorMessage", MessageManager.getProperty("message.servererror"));
                page = ConfigurationManager.getProperty("path.page.registration");
            } catch (DuplicationException e) {
                request.setAttribute("errorMessage", MessageManager.getProperty("message.duplicerror"));
                page = ConfigurationManager.getProperty("path.page.registration");
            }
        }
        else{
            request.setAttribute("errorMessage",  MessageManager.getProperty("message.syntaxerror"));
            page = ConfigurationManager.getProperty("path.page.registration");
        }

        return page;
    }
}
