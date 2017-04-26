package by.training.nc.dev5.controller;

import by.training.nc.dev5.daoService.LoanService;
import by.training.nc.dev5.model.Loan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ASUS on 26.04.2017.
 */
@WebServlet("/loanController")
public class LoanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("loans",new LoanService().selectLoans());
        ((ArrayList<Loan>)req.getSession().getAttribute("loans")).forEach(System.out::println);
        getServletContext().getRequestDispatcher("/pages/loans.jsp").forward(req, resp);
    }

}
