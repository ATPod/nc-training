package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Qualification;

import java.util.Map;
import java.util.TreeMap;

/**
 * A convenience class to create tasks
 *
 * @author Nikita Atroshenko
 */
public class TaskBuilder {
    private Map<Qualification, Integer> developers;
    private String specification;

    public TaskBuilder() {
        developers = new TreeMap<>();
    }

    /**
     * Add developers of specified qualification to quota
     * @param q qualification of developers group
     * @param n developers number increment
     */
    public void addDevelopers(Qualification q, int n) {
        if (developers.containsKey(q)) {
            int prev = developers.get(q);

            developers.replace(q, prev + n);
        }
    }

    /**
     * Sets task specification
     * @param specification the value for task specification
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * Create task with provided specification and quota
     * @return a task with specified parameters
     */
    public Task createTask() {
        Task t = new Task();

        t.setQuota(developers);
        t.setSpecification(specification);

        return t;
    }
}
