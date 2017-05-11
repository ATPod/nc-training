package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.QualificationServiceImpl;
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
public class GoCreateTermsCommand implements Command {
    private QualificationService qualificationService;
    private Router router;

    {
        router = Router.getInstance();
        qualificationService = new QualificationServiceImpl();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        Collection<QualificationDto> qualifications =
                qualificationService.getQualifications();

        request.setAttribute("qualifications", qualifications);

        router.forward(request, response, "path.page.customer.createTerms");
    }
}
