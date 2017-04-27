package by.training.nc.dev5.filters;

import by.training.nc.dev5.utils.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Session per request
public class SessionClosingFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Session session = HibernateUtil.getInstance().getSession();
        chain.doFilter(request, response);
        HibernateUtil.getInstance().releaseSession(session);
    }

    public void destroy() {
    }
}

