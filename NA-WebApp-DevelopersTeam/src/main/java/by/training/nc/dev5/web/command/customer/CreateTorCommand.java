package by.training.nc.dev5.web.command.customer;

import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.service.CustomerService;
import by.training.nc.dev5.service.TermsOfReferenceBuilder;
import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nikita on 19.04.2017.
 */
public class CreateTorCommand implements Command {
    public String execute(HttpServletRequest request) {
        CustomerService customerService = (CustomerService) request.getSession()
                .getServletContext().getAttribute("customerService");
        TermsOfReferenceBuilder builder = fetchTorBuilder(request);
        Customer user = (Customer) request.getSession().getAttribute("user");
        String page = ConfigurationManager.getInstance().getString(
                "path.page.customer.showTors");

        builder.setCustomer(user);
        TermsOfReference tor = builder.createTermsOfReference();

        customerService.proposeTermsOfReference(tor);

        return page;
    }

    private TermsOfReferenceBuilder fetchTorBuilder(HttpServletRequest request) {
        Object attr = request.getSession().getAttribute("torBuilder");

        return (TermsOfReferenceBuilder) attr;
    }
}
