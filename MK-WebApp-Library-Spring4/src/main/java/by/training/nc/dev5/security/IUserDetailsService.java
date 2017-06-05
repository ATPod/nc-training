package by.training.nc.dev5.security;

import by.training.nc.dev5.entity.User;
import by.training.nc.dev5.jpaservice.UserService;
import by.training.nc.dev5.util.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Service("IUserDetailsService")
public class IUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(user!=null){
            request.getSession().setAttribute(Attributes.USER,user);
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),grantedAuthorities);
        }
        return null;
    }
}
