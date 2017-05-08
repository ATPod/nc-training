package by.training.nc.dev5.clinic.utils;

import by.training.nc.dev5.clinic.commands.ICommand;
import by.training.nc.dev5.clinic.commands.factory.CommandFactory;
import by.training.nc.dev5.clinic.constants.ConfigConstants;
import by.training.nc.dev5.clinic.managers.PagePathManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 07.05.2017.
 */
public class RequestHandler {
    public static void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandFactory commandFactory = CommandFactory.getInstance();
        ICommand command = commandFactory.defineCommand(request);
        String page = command.execute(request);
        if(page != null){
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
        else{
            page = PagePathManager.getInstance().getProperty(ConfigConstants.INDEX_PAGE_PATH);
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
