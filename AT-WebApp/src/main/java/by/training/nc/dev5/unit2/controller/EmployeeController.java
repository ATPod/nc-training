package by.training.nc.dev5.unit2.controller;

import by.training.nc.dev5.unit2.service.AuthenticationService;
import by.training.nc.dev5.unit2.service.EmployeeService;
import by.training.nc.dev5.unit2.utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ants0716 on 28.03.2017.
 */

@WebServlet("/")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthenticationService authenticationService = new AuthenticationService();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(Constants.SUCCESS);
        if(authenticationService.isUserFound(req.getParameter("username"),req.getParameter("password"))){
            EmployeeService employeeService = new EmployeeService();
            req.setAttribute("employees", employeeService.getEmployees());
        } else{
            requestDispatcher = req.getRequestDispatcher(Constants.ERROR);
        }
        requestDispatcher.forward(req, resp);
    }
}
