package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.PersonDao;
import by.training.nc.dev5.entity.Person;
import by.training.nc.dev5.entity.metamodel.Person_;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

/**
 * Created by Nikita on 04.05.2017.
 */
public class PersonJpaDao
        extends AbstractJpaDao<Person, Integer>
        implements PersonDao {

    public PersonJpaDao(EntityManager entityManager) {
        super(entityManager, Person.class);
    }

    public Person getPersonByLogin(String login) throws DataAccessException {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> fromPerson = cq.from(Person.class);
        Path<String> loginPath = fromPerson.get(Person_.login);

        cq.where(cb.equal(loginPath, login));
        cq.select(fromPerson);

        TypedQuery<Person> q = getEntityManager().createQuery(cq);

        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DataAccessException("Persistence exception occurred", e);
        }
    }
}
