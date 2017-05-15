package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.entity.metamodel.Project_;
import by.training.nc.dev5.entity.metamodel.TermsOfReference_;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
public class ProjectJpaDao
        extends AbstractJpaDao<Project, Integer>
        implements ProjectDao {
    public ProjectJpaDao(EntityManager em) {
        super(em, Project.class);
    }

    public Project getProject(Integer termsOfReferenceId)
            throws DataAccessException {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Project> cq = cb.createQuery(Project.class);
        Root<Project> fromProject = cq.from(Project.class);
        Path<TermsOfReference> torPath =
                fromProject.get(Project_.termsOfReference);
        Path<Integer> torIdPath = torPath.get(TermsOfReference_.id);

        cq.where(cb.equal(torIdPath, termsOfReferenceId));
        cq.select(fromProject);

        TypedQuery<Project> q = getEntityManager().createQuery(cq);

        try {
            return q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DataAccessException("Persistence exception occurred", e);
        }
    }

    public Collection<Project> getProjects(int managerId)
            throws DataAccessException {

        TypedQuery<Project> q = getEntityManager().createQuery(
                "select p from Project p where p.manager.id = :managerId",
                Project.class
        );

        return q.setParameter("managerId", managerId).getResultList();
    }
}
