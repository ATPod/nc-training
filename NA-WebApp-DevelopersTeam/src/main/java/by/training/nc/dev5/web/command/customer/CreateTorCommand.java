package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.service.CustomerService;
import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.routing.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 19.04.2017.
 */
public class CreateTorCommand implements Command {
    public void execute(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {

        CustomerService customerService = (CustomerService) request.getSession()
                .getServletContext().getAttribute("customerService");
        TermsOfReferenceBuilder builder = fetchTorBuilder(request);
        Customer user = (Customer) request.getSession().getAttribute("user");
        TermsOfReference tor;

        builder.setCustomer(user);
        tor = builder.createTermsOfReference();
        customerService.proposeTermsOfReference(tor);

        Router.redirect(response, "path.page.customer.main");
    }

    private TermsOfReferenceBuilder fetchTorBuilder(HttpServletRequest request) {
        Object attr = request.getSession().getAttribute("torBuilder");

        return (TermsOfReferenceBuilder) attr;
    }
}
