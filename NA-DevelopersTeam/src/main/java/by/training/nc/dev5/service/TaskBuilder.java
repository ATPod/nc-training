package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TaskQuota;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 27.03.2017.
 */
public abstract class TaskBuilder {
    private Map<Integer, Integer> qualificationDevelopersNumberMap;
    private Task task;

    protected abstract DaoFactory getDaoFactory();

    public TaskBuilder() {
        task = new Task();
        qualificationDevelopersNumberMap = new HashMap<Integer, Integer>();
    }

    /**
     * Sets the value of specification
     *
     * @param specification the new value of specification.
     */
    public void setSpecification(String specification) {
        task.setSpecification(specification);
    }

    public Task createTask() {
        DaoFactory daoFactory = getDaoFactory();
        TaskDao taskDao = daoFactory.getTaskDao();
        TaskQuotaDao taskQuotaDao = daoFactory.getTaskQuotaDao();

        task.setId(taskDao.create(task));

        for (Map.Entry<Integer, Integer> entry :
                qualificationDevelopersNumberMap.entrySet()) {
            TaskQuota tq = new TaskQuota();

            if (entry.getValue() == 0) {
                continue;
            }
            tq.setQualificationId(entry.getKey());
            tq.setDevelopersNumber(entry.getValue());
            tq.setTaskId(task.getId());

            tq.setId(taskQuotaDao.create(tq));
        }

        return task;
    }

    public void setDevelopersNumber(int qualificationId, int number) {
        qualificationDevelopersNumberMap.put(qualificationId, number);
    }
}
