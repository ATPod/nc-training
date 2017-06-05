package by.training.nc.dev5.web.security;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nikita on 31.05.2017.
 */
@Service("userDetailsService")
@SessionAttributes("user")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private HttpServletRequest request;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Person user = personDao.getPersonByLogin(login);
        UserDetails userDetails;

        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        PersonDto personDto = instantiatePersonDto(user);

        request.getSession().setAttribute("user", personDto);

        roles.add(new SimpleGrantedAuthority("ROLE_" + user.getUserRole()));
        userDetails = new User(user.getLogin(), user.getPassword(), roles);

        return userDetails;
    }

    private PersonDto instantiatePersonDto(Person person) {
        PersonDto dto;

        switch (person.getUserRole()) {
            case CUSTOMER:
                dto =  new CustomerDto();
                break;
            case DEVELOPER:
                dto = new DeveloperDto();
                setDeveloperDto((DeveloperDto) dto, (Developer) person);
                break;
            case MANAGER:
                dto = new ManagerDto();
                break;
            default:
                return null; // unsupported user role
        }

        dto.setName(person.getName());
        dto.setId(person.getId());

        return dto;
    }

    private void setDeveloperDto(DeveloperDto dto, Developer entity) {
        Project project = projectDao.getProjectByDeveloper(entity.getId());
        ProjectDto projectDto = null;
        QualificationDto qualificationDto = new QualificationDto();

        if (project != null) {
            projectDto = new ProjectDto();
            projectDto.setId(project.getId());
        }
        dto.setProject(projectDto);
        qualificationDto.setId(entity.getQualification().getId());
        dto.setQualification(qualificationDto);
    }
}
