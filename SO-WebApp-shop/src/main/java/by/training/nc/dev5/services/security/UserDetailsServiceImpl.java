package by.training.nc.dev5.services.security;

import by.training.nc.dev5.entity.Product;
import by.training.nc.dev5.entity.UserRoleEnum;
import by.training.nc.dev5.entity.Administrator;
import by.training.nc.dev5.entity.Client;
import by.training.nc.dev5.exceptions.DaoException;
import by.training.nc.dev5.exceptions.NotFoundException;
import by.training.nc.dev5.services.IAdministratorService;
import by.training.nc.dev5.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IAdministratorService administratorService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Pattern pattern =  Pattern.compile("\\A[^@]+@([^@\\.]+\\.)+[^@\\.]+\\z");
        Matcher matcher = pattern.matcher(username);

        if (matcher.matches()) {
            Client client = null;

            try {
                client = clientService.findClientByEmail(username);

                request.getSession().setAttribute("user", client);
                request.getSession().setAttribute("bag", new ArrayList<Product>());

                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority(UserRoleEnum.CLIENT.name()));

                UserDetails userDetails = new User(client.getEmail(), client.getPassword(), roles);

                return userDetails;

            } catch (NotFoundException | DaoException e) {}
        }
        else {
            try {
                Administrator administrator = administratorService.findAdministratorByName(username);

                request.getSession().setAttribute("user", administrator);

                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));

                UserDetails userDetails = new User(administrator.getName(), administrator.getPassword(), roles);
                return userDetails;
            } catch (NotFoundException | DaoException e) {}
        }
        return null;
    }

}
