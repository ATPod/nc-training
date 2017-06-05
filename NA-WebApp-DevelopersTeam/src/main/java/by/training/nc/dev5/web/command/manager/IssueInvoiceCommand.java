package by.training.nc.dev5.web.command.manager;

import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.service.InvoiceService;
import by.training.nc.dev5.service.InvoiceServiceImpl;
import by.training.nc.dev5.service.ProjectService;
import by.training.nc.dev5.service.ProjectServiceImpl;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 13.05.2017.
 */
public class IssueInvoiceCommand implements Command {
    private InvoiceService invoiceService;
    private Router router;

    {
        invoiceService = new InvoiceServiceImpl();
        router = Router.getInstance();
    }

    public void execute(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, IOException {

        int projectId = Integer.parseInt(request.getParameter("projectId"));
        double price = Double.parseDouble(request.getParameter("price"));
        ProjectDto project = new ProjectDto();
        String uri = "home";

        project.setId(projectId);

        invoiceService.issueInvoice(project, price);

        router.redirect(request, response, uri);
    }
}
