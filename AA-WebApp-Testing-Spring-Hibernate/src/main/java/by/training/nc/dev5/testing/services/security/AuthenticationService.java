package by.training.nc.dev5.testing.services.security;

import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.logger.TestingSystemLogger;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Spring Security also includes a UserDetailsService that can obtain
 * authentication information from a JDBC data source.
 * If your application does use an ORM tool,
 * you might prefer to write a custom UserDetailsService
 * implementation
 */
@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        UserDetails userDetails = null;
        try {
            user = userService.getAuthorizedUser(login);
            if (user == null) {
                TestingSystemLogger.INSTANCE.logError(getClass(), "USER_NOT_FOUND");
                throw new UsernameNotFoundException("USER_NOT_FOUND");
            }
            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority("ROLE_" + user.getUserType()));
            userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(),
                    user.getPassword(),
                    roles);


        } catch (ServiceException e) {
            TestingSystemLogger.INSTANCE.logError(getClass(), "EXCEPTION");
            e.printStackTrace();
        }
        return userDetails;

    }

}
