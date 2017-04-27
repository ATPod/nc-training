package by.training.nc.dev5.web.servlet;

import by.training.nc.dev5.util.ConfigurationManager;
import by.training.nc.dev5.web.command.Command;
import by.training.nc.dev5.web.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 18.04.2017.
 */
public class Controller extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String page;
        CommandFactory factory = new CommandFactory();
        Command action = factory.getCommand(req);

        page = action.execute(req);

        if (page != null) {
            RequestDispatcher rd = req.getRequestDispatcher(page);

            rd.forward(req, resp);
        } else {
            page = ConfigurationManager.getInstance()
                    .getString("path.page.index");
            resp.sendRedirect(page);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        processRequest(req, resp);
    }

    @Override
    public void destroy() {}

    @Override
    public void init() {}
}
