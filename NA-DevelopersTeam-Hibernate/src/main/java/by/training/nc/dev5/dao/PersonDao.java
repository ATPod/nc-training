package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.exception.DataAccessException;

/**
 * Created by F1 on 12.04.2017.
 */
public interface PersonDao extends AbstractDao<Person, Integer> {
    Person getPersonByLogin(String login) throws DataAccessException;
}
