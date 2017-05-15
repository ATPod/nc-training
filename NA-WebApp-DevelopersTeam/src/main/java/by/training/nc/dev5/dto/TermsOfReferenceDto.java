package by.training.nc.dev5.dto;

import java.util.Collection;

/**
 * Created by Nikita on 08.05.2017.
 */
public class TermsOfReferenceDto {
    private int id;
    private Collection<TaskDto> tasks;
    private CustomerDto customer;

    /**
     * Gets the value of tasks
     *
     * @return the value of tasks.
     */
    public Collection<TaskDto> getTasks() {
        return tasks;
    }

    /**
     * Sets the value of tasks
     *
     * @param tasks the new value of tasks.
     */
    public void setTasks(Collection<TaskDto> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets the value of customer
     *
     * @return the value of customer.
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * Sets the value of customer
     *
     * @param customer the new value of customer.
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * Gets the value of id
     *
     * @return the value of id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id
     *
     * @param id the new value of id.
     */
    public void setId(int id) {
        this.id = id;
    }
}
