package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.metamodel.Developer_;
import by.training.nc.dev5.entity.metamodel.Project_;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 04.05.2017.
 */
public class DeveloperJpaDao
        extends AbstractJpaDao<Developer, Integer>
        implements DeveloperDao{
    public DeveloperJpaDao(EntityManager entityManager) {
        super(entityManager, Developer.class);
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

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Developer> cq = cb.createQuery(Developer.class);
        Root<Developer> fromDeveloper = cq.from(Developer.class);
        Path<Project> projectPath = fromDeveloper.get(Developer_.project);

        cq.where(cb.isNull(projectPath));
        cq.select(fromDeveloper);

        TypedQuery<Developer> q = getEntityManager().createQuery(cq);
        List<Developer> result = q.getResultList();

        return result;
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

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Developer> cq = cb.createQuery(Developer.class);
        Root<Developer> fromDeveloper = cq.from(Developer.class);
        Path<Project> projectPath = fromDeveloper.get(Developer_.project);
        Path<Integer> projectIdPath = projectPath.get(Project_.id);

        cq.where(cb.equal(projectIdPath, projectId));
        cq.select(fromDeveloper);

        TypedQuery<Developer> q = getEntityManager().createQuery(cq);
        List<Developer> result = q.getResultList();

        return result;
    }
}
