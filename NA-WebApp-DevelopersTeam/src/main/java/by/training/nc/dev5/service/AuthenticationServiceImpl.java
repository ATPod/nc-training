package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.CustomerDto;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ManagerDto;
import by.training.nc.dev5.dto.PersonDto;
import by.training.nc.dev5.entity.Customer;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Person;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 08.05.2017.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final DaoFactory DAO_FACTORY = new JpaDaoFactory();

    private PersonDao personDao = DAO_FACTORY.getPersonDao();

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
        switch (person.getUserRole()) {
            case CUSTOMER:
                return new CustomerDto();
            case DEVELOPER:
                return new DeveloperDto();
            case MANAGER:
                return new ManagerDto();
            default:
                return null; // unsupported user role
        }
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
}
