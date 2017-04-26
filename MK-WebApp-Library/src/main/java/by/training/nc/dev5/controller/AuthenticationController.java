package by.training.nc.dev5.controller;


import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by ASUS on 22.04.2017.
 */

@WebServlet("/loginController")
public class AuthenticationController extends HttpServlet {


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);

        System.out.println(req.getParameter("command"));


    }
}
