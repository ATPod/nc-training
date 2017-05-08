package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.PersonDto;

import java.util.Collection;

/**
 * Created by Nikita on 08.05.2017.
 */
public interface AuthenticationService {
    PersonDto authenticate(String login, String password);
    Collection<PersonDto> getAllPeople();
    void addPerson(PersonDto person, String login, String password);
}
