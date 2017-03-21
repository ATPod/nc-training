package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Customer;

import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public class TermsOfReference {
    private Customer c;
    private List<Task> tasks;

    /**
     * Gets the value of tasks
     *
     * @return the value of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets the value of tasks
     *
     * @param tasks the new value of tasks.
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
