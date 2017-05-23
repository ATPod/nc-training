package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.accounts.UserRole;
import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.entity.*;
import by.training.nc.dev5.service.AuthenticationService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 08.05.2017.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    private static DaoFactory daoFactory;
    private PersonDao personDao;
    private ProjectDao projectDao;

    static {
        daoFactory = new JpaDaoFactory();
    }

    {
        personDao = daoFactory.getPersonDao();
        projectDao = daoFactory.getProjectDao();
    }

    public PersonDto authenticate(String login, String password) {
        Person person = personDao.getPersonByLogin(login);
        PersonDto personDto;

        if (person == null) {
            return null;
        }

        personDto = instantiatePersonDto(person);

        if (personDto == null) {
            return null;
        }

        if (!checkPassword(person, password)) {
            return null;
        }

        personDto.setName(person.getName());

        return personDto;
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

    /**
     * Checks password for validity
     * @param person    user's data from repository
     * @param password  client's password
     * @return  true if password is valid, false otherwise
     * @throws NullPointerException if person is <code>null</code>
     */
    private boolean checkPassword(Person person, String password) {
        return person.getPassword().equals(password);
    }

    public Collection<PersonDto> getAllPeople() {
        Collection<Person> all = personDao.getAll();
        Collection<PersonDto> result = new ArrayList<PersonDto>(all.size());

        for (Person person : all) {
            PersonDto personDto = instantiatePersonDto(person);

            if (personDto != null) {
                result.add(personDto);
            }
        }

        return result;
    }

    public boolean isLoginExist(String login) {
        return personDao.getPersonByLogin(login) != null;
    }

    public void addPerson(PersonDto personDto, String login, String password) {
        Person person;

        switch (personDto.getUserRole()) {
            case CUSTOMER:
                person = new Customer();
                break;
            case DEVELOPER:
                person = new Developer();
                break;
            case MANAGER:
                person = new Manager();
                break;
            default:
                throw new IllegalArgumentException("Unsupported role type");
        }

        person.setLogin(login);
        person.setPassword(password);

        personDao.create(person);
    }

    public UserRole[] getSupportedRoles() {
        return new UserRole[] {
                UserRole.CUSTOMER, UserRole.DEVELOPER, UserRole.MANAGER
        };
    }
}
