package by.training.nc.dev5.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Nikita on 02.06.2017.
 */
public class EncodingFilter implements Filter {
    private String initParamEncoding;

    public void init(FilterConfig filterConfig) throws ServletException {
        initParamEncoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest req,
                         ServletResponse resp,
                         FilterChain chain)
            throws IOException, ServletException {

        String requestEncoding = req.getCharacterEncoding();

        if (initParamEncoding != null &&
                !initParamEncoding.equalsIgnoreCase(requestEncoding)) {

            req.setCharacterEncoding(initParamEncoding);
            resp.setCharacterEncoding(initParamEncoding);
        }

        resp.setContentType("UTF-8");
        chain.doFilter(req, resp);    }

    public void destroy() {}
}
