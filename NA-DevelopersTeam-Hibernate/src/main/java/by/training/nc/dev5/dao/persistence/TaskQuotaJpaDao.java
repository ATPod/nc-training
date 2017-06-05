package by.training.nc.dev5.dao.persistence;

import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.entity.TaskQuota;
import by.training.nc.dev5.exception.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.Collection;

/**
 * Created by Nikita on 07.05.2017.
 */
//@Repository
public class TaskQuotaJpaDao
        extends AbstractJpaDao<TaskQuota, Integer>
        implements TaskQuotaDao {
//    @Autowired
    public TaskQuotaJpaDao(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, TaskQuota.class);
    }

    /**
     * Gets task quotas associated with specified task
     *
     * @param taskId a task id to get task quotas of
     * @return a collection of task quotas
     */
    public Collection<TaskQuota> getTaskQuotas(int taskId) throws DataAccessException {
        try {
            TypedQuery<TaskQuota> q = getEntityManager().createQuery(
                    "select tq from TaskQuota tq where tq.task.id = :taskId",
                    TaskQuota.class
            );

            q.setParameter("taskId", taskId);

            return q.getResultList();
        } catch (PersistenceException e) {
            throw new DataAccessException(e);
        }
    }
}
