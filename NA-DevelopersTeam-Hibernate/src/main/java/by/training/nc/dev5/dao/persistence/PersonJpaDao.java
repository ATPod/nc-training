package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.entity.metamodel.Person_;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.*;

/**
 * Created by Nikita on 04.05.2017.
 */
@Repository
public class PersonJpaDao
        extends AbstractJpaDao<Person, Integer>
        implements PersonDao {

    @Autowired
    public PersonJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Person.class);
    }

    public Person getPersonByLogin(String login) throws DataAccessException {
        TypedQuery<Person> q = getEntityManager().createQuery(
                "select p from Person p where p.login = :login",
                Person.class
        );

        try {
            q.setParameter("login", login);

            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (PersistenceException e) {
            throw new DataAccessException("Persistence exception occurred", e);
        }
    }
}
