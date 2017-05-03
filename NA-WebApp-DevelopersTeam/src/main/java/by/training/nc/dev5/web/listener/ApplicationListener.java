package by.training.nc.dev5.web.listener; /**
 * Created by Nikita on 24.04.2017.
 */

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.service.AuthenticationService;
import by.training.nc.dev5.service.CustomerService;
import by.training.nc.dev5.service.HelpService;
import by.training.nc.dev5.service.ManagerService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ApplicationListener implements ServletContextListener {

    private AuthenticationService authenticationService;
    private CustomerService customerService;
    private ManagerService managerService;
    private HelpService helpService;

    // TODO: 03.05.2017 The only thing worse is scriptlet. Find better solution
    private UserRole[] userRoles;

    // Public constructor is required by servlet spec
    public ApplicationListener() {
        authenticationService = new AuthenticationService();
        customerService = new CustomerService();
        managerService = new ManagerService();
        helpService = new HelpService();

        userRoles = UserRole.values();
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

      sce.getServletContext().setAttribute(
              "authenticationService", authenticationService);
      sce.getServletContext().setAttribute("customerService", customerService);
      sce.getServletContext().setAttribute("managerService", managerService);
      sce.getServletContext().setAttribute("helpService", helpService);

      sce.getServletContext().setAttribute("userRoles", userRoles);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }
}
