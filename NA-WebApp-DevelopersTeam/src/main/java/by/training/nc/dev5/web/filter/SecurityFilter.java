package by.training.nc.dev5.web.filter;

import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.util.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Nikita on 19.04.2017.
 */
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {

//        HttpServletRequest httpReq = (HttpServletRequest) req;
//        HttpSession session = httpReq.getSession();
//        Person user = (Person) session.getAttribute("user");
//
//        if (user == null) {
//            RequestDispatcher rd = req.getServletContext().getRequestDispatcher(
//                    ConfigurationManager.getInstance()
//                            .getString("path.page.login")
//            );
//            httpReq.setAttribute("desiredUri", ((HttpServletRequest) req).getRequestURI());
//            rd.forward(req, resp);
//        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
