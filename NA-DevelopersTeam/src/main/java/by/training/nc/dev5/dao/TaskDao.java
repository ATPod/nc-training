package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Task;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface TaskDao extends AbstractDao<Task, Integer> {
    Collection<Task> getTasks(Integer termsOfReferenceId);
}
