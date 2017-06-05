package by.training.nc.dev5.web.security;

import by.training.nc.dev5.dto.PersonDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nikita on 31.05.2017.
 */
@Service("authenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    public void onAuthenticationSuccess(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication) throws IOException, ServletException {

        PersonDto personDto =
                ((PersonUserDetails) authentication.getPrincipal())
                        .getPersonDto();

        httpServletRequest.getSession().setAttribute("user", personDto);

        new DefaultRedirectStrategy().sendRedirect(
                httpServletRequest,
                httpServletResponse,
                "/home");
    }
}
