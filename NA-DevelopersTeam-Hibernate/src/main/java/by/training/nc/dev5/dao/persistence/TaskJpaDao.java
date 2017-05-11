package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.persistence.AbstractJpaDao;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.entity.metamodel.Task_;
import by.training.nc.dev5.entity.metamodel.TermsOfReference_;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Collection;
import java.util.List;

/**
 * Created by Nikita on 07.05.2017.
 */
public class TaskJpaDao
        extends AbstractJpaDao<Task, Integer>
        implements TaskDao {

    public TaskJpaDao(EntityManager em) {
        super(em, Task.class);
    }

    public Collection<Task> getTasks(Integer termsOfReferenceId)
            throws DataAccessException {
//        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
//        CriteriaQuery<Task> cq = cb.createQuery(Task.class);
//        Root<Task> fromTask = cq.from(Task.class);
//        Path<TermsOfReference> torPath = fromTask.get(Task_.termsOfReference);
//        Path<Integer> torIdPath = torPath.get(TermsOfReference_.id);
//
//        cq.where(cb.equal(torIdPath, termsOfReferenceId));
//        cq.select(fromTask);

        TypedQuery<Task> q = getEntityManager().createQuery(
                "select t from Task t where t.termsOfReference.id = :torId",
                Task.class
        );

        q.setParameter("torId", termsOfReferenceId);

        return q.getResultList();
    }
}
