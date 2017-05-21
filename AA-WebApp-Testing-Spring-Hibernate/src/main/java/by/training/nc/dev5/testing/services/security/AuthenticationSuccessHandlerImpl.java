package by.training.nc.dev5.testing.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        process(httpServletRequest, httpServletResponse, authentication);
    }

    //Обработка запроса
    protected void process(HttpServletRequest request,
                           HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = defineTargetUrl(authentication);

        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    //Определить куда надо перейти при успешной авторизации
    protected String defineTargetUrl(Authentication authentication) {
        boolean isStudent = false;
        boolean isTutor = false;
        String pagePath;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_STUDENT")) {
                isStudent = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_TUTOR")) {
                isTutor = true;
                break;
            }

        }
        if (isStudent) {
            pagePath = "/studentProfile";
        } else if (isTutor) {
            pagePath = "/tutorProfile";
        } else {
            pagePath = "/error";
        }
        return pagePath;
    }
}
