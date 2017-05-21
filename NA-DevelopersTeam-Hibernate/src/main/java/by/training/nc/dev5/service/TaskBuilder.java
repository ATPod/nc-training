package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.dao.TaskDao;
import by.training.nc.dev5.dao.TaskQuotaDao;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.entity.Task;
import by.training.nc.dev5.entity.TaskQuota;
import by.training.nc.dev5.entity.TermsOfReference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 27.03.2017.
 */
public class TaskBuilder {
    private Map<Qualification, TaskQuota> taskQuotas;
    private Task task;

    public TaskBuilder() {
        task = new Task();
        taskQuotas = new HashMap<Qualification, TaskQuota>();
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
        task.setTaskQuotas(taskQuotas.values());

        return task;
    }

    public void setDevelopersNumber(Qualification qualification, int number) {
        TaskQuota taskQuota = new TaskQuota();

        if (taskQuotas.containsKey(qualification)) {
            taskQuotas.remove(qualification);
        }
        if (number == 0) {
            return;
        }

        taskQuota.setQualification(qualification);
        taskQuota.setDevelopersNumber(number);
        taskQuota.setTask(task);

        taskQuotas.put(qualification, taskQuota);
    }
}
