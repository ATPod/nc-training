package by.training.nc.dev5.web.command.manager;

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
 * Created by Nikita on 10.05.2017.
 */
public class GoShowPendingTerms implements Command {
    private TermsOfReferenceService termsOfReferenceService;
    private Router router;

    {
        termsOfReferenceService = new TermsOfReferenceServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        Collection<TermsOfReferenceDto> pendingTerms =
                termsOfReferenceService.getPendingTerms();

        request.setAttribute("pendingTerms", pendingTerms);

        router.forward(request, response, "path.page.manager.showPendingTors");
    }
}
