package by.training.nc.dev5.web.listener; /**
 * Created by Nikita on 24.04.2017.
 */

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

    private CustomerService customerService;
    private ManagerService managerService;
    private HelpService helpService;

    // Public constructor is required by servlet spec
    public ApplicationListener() {
        customerService = new CustomerService();
        managerService = new ManagerService();
        helpService = new HelpService();
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

      sce.getServletContext().setAttribute("customerService", customerService);
      sce.getServletContext().setAttribute("managerService", managerService);
      sce.getServletContext().setAttribute("helpService", helpService);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }
}