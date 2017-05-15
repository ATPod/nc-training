package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;
import by.training.nc.dev5.service.TermsOfReferenceService;
import by.training.nc.dev5.service.TermsOfReferenceServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Nikita on 09.05.2017.
 */
public class GoShowTermsCommand implements Command {
    private TermsOfReferenceService termsOfReferenceService;
    private Router router;

    {
        termsOfReferenceService = new TermsOfReferenceServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        CustomerDto user = (CustomerDto) request.getSession()
                .getAttribute("user");
        Collection<TermsOfReferenceDto> terms = termsOfReferenceService
                .getTermsByCustomer(user);

        request.setAttribute("terms", terms);

        router.forward(request, response, "path.page.customer.showMyTerms");
    }
}
