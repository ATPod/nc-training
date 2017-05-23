package by.training.nc.dev5.web.filter;

import by.training.nc.dev5.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 10.05.2017.
 */
public class EntityManagerFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        EntityManager em = JpaUtil.getInstance().getEntityManager();

        // TODO: BAAAAAAAAAAAAAAAAAD
        // TODO: how to filter forwarded requests?
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
        filterChain.doFilter(servletRequest, servletResponse);
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }

        JpaUtil.getInstance().releaseEntityManager(em);
    }

    public void destroy() {}
}
