package by.training.nc.dev5.web.security;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita on 31.05.2017.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonDao personDao;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person user = personDao.getPersonByLogin(login);
        UserDetails userDetails;

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRole()));
        userDetails = new User(user.getLogin(), user.getPassword(), roles);

        return userDetails;
    }
}
