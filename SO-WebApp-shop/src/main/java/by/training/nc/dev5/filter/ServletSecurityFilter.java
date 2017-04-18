package by.training.nc.dev5.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.DispatcherType;

//@WebFilter(dispatcherTypes = {
//    DispatcherType.REQUEST,
//    DispatcherType.FORWARD,
//    DispatcherType.INCLUDE
//    }, urlPatterns = { "/jsp/*" })
@WebFilter(urlPatterns = { "/controller" }, servletNames = { "Controller" })
public class ServletSecurityFilter implements Filter {
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == null ) {
            type = ClientType.GUEST;
            session.setAttribute("userType", type);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {}
}
