package by.training.nc.dev5.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ASUS on 26.04.2017.
 */
@WebServlet("/bookController")

public class BookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("command")==null) {
            getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }else if(req.getParameter("command").equals("view")){
            getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);

        }

    }



}
