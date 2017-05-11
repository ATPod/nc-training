package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;
import by.training.nc.dev5.service.TermsOfReferenceService;
import by.training.nc.dev5.service.TermsOfReferenceServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 19.04.2017.
 */
public class CreateTermsCommand implements Command {
    private TermsOfReferenceService termsOfReferenceService;
    private Router router;

    private void initializeServices() {
        termsOfReferenceService = new TermsOfReferenceServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        TermsOfReferenceDto terms = (TermsOfReferenceDto) request.getSession()
                .getAttribute("createdTerms");
        CustomerDto user = (CustomerDto) request.getSession()
                .getAttribute("user");

        // TODO: find better solution than initialize services each request
        initializeServices();

        terms.setCustomer(user);
        termsOfReferenceService.applyTermsOfReference(terms);

        String uri = "/controller?command=goCreateTerms";

        request.getSession().removeAttribute("createdTerms");

        router.redirect(request, response, uri);
    }
}
