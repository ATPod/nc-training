package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.exception.DataAccessException;

/**
 * Created by Nikita on 04.05.2017.
 */
public class PersonJpaDao implements PersonDao {

    public Person getPersonByLogin(String login) throws DataAccessException {
        return null;
    }
}
