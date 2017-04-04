package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.TaskQuota;

import java.util.Collection;

/**
 * Created by Nikita on 28.03.2017.
 */
public interface TaskQuotaDao extends AbstractDao<TaskQuota, Integer> {
    /**
     * Gets task quotas associated with specified task
     * @param taskId a task id to get task quotas of
     * @return a collection of task quotas
     */
    Collection<TaskQuota> getTaskQuotas(int taskId);
}
