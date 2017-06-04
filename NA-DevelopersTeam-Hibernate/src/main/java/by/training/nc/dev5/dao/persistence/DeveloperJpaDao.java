package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 04.05.2017.
 */
//@Repository
public class DeveloperJpaDao
        extends AbstractJpaDao<Developer, Integer>
        implements DeveloperDao{

//    @Autowired
    public DeveloperJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, Developer.class);
    }

    /**
     * Gets all developers of particular qualification that are not assigned
     * to any project at the moment.
     *
     * @param qualificationId qualification of developers to look up.
     * @return a collection of {@link Developer} objects
     */
    public Collection<Developer> getUnassignedDevelopers(
            Integer qualificationId) throws DataAccessException {

        try {
            TypedQuery<Developer> q = getEntityManager().createQuery(
                    "select d from Developer d" +
                            " where d.project is null" +
                            " and d.qualification.id = :qualificationId",
                    Developer.class
            );

            return q.setParameter("qualificationId", qualificationId).getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    /**
     * Gets developers assigned to this project
     *
     * @param projectId project id to get assigned developers
     * @return a collection of developers that are assigned to project
     * identified by {@code projectId}
     */
    public Collection<Developer> getDevelopers(Integer projectId)
            throws DataAccessException {

        try {
            TypedQuery<Developer> q = getEntityManager().createQuery(
                    "select d from Developer d where d.project.id = :projectId",
                    Developer.class
            );

            return q.setParameter("projectId", projectId).getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }

    public Collection<Developer> getUnassignedDevelopers() {
        try {
            TypedQuery<Developer> q = getEntityManager().createQuery(
                    "select d from Developer d where d.project is null",
                    Developer.class
            );

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
