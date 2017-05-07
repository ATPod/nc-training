package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.entity.TaskQuota;
import by.training.nc.dev5.exception.DataAccessException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
public class TaskQuotaJpaDao
        extends AbstractJpaDao<TaskQuota, Integer>
        implements TaskQuotaDao {
    public TaskQuotaJpaDao(EntityManager em) {
        super(em, TaskQuota.class);
    }

    /**
     * Gets task quotas associated with specified task
     *
     * @param taskId a task id to get task quotas of
     * @return a collection of task quotas
     */
    public Collection<TaskQuota> getTaskQuotas(int taskId) throws DataAccessException {
        TypedQuery<TaskQuota> q = getEntityManager().createQuery(
                "select tq from TaskQuota tq where tq.task.id = :taskId",
                TaskQuota.class
        );

        q.setParameter("taskId", taskId);

        return q.getResultList();
    }
}
