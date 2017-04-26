package by.training.nc.dev5.controller;

import by.training.nc.dev5.daoService.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ASUS on 25.04.2017.
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("command") == null) {
            getServletContext().getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        } else if (req.getParameter("command").equals("login")) {

            UserService us = new UserService();

            String name = req.getParameter("txtUserName").trim();
            String pass = req.getParameter("txtPass").trim();

            boolean isLogged = us.loginUser(name,pass);
            req.getSession(true).setAttribute("isLogged",isLogged);

            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
}
