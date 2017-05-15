package by.training.nc.dev5.testing.filters;

import javax.servlet.*;
import java.io.IOException;
public class EncodingFilter implements Filter{

	private String initParamEncoding;
	@Override
	public void destroy() {}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    //Set character encoding as UTF-8
		String requestEncoding = request.getCharacterEncoding();
		if (initParamEncoding != null && !initParamEncoding.equalsIgnoreCase(requestEncoding)) {
			request.setCharacterEncoding(initParamEncoding);
			response.setCharacterEncoding(initParamEncoding);
		}
		filterChain.doFilter(request, response);
	}
	@Override
	public void init(FilterConfig config) throws ServletException {
        //get init param from web.xml
		initParamEncoding = config.getInitParameter("encoding");
	}

}
