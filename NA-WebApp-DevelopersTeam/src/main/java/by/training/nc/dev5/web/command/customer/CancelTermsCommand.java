package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 09.05.2017.
 */
public class CancelTermsCommand implements Command {

    private final Router router;

    {
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("createdTerms");

        router.redirect(request, response, "home");
    }
}
