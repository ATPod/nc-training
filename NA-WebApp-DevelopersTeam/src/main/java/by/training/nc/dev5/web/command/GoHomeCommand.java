package by.training.nc.dev5.web.command;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nikita on 26.04.2017.
 */
public class GoHomeCommand implements Command {
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        Person user = (Person) request.getSession().getAttribute("user");

        if (user == null) {
            return ConfigurationManager.getInstance()
                    .getString("path.page.index");
        }

        if (user.getUserRole().equals(UserRole.CUSTOMER)) {
            return ConfigurationManager.getInstance()
                    .getString("path.page.customer.main");
        } else if (user.getUserRole().equals(UserRole.MANAGER)) {
            return ConfigurationManager.getInstance()
                    .getString("path.page.manager.main");
        } else {
            return ConfigurationManager.getInstance()
                    .getString("path.page.developer.main");
        }
    }
}
