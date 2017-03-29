package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Customer;

import java.util.Arrays;
import java.util.List;

/**
 * Contains initial information for a new project
 *
 * @author Nikita Atroshenko
 */
public class TermsOfReference {
    private int id;
    private Customer customer;
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

    /**
     * Gets the value of customer
     *
     * @return the value of customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of customer
     *
     * @param customer the new value of customer.
     */
    public void setCustomer(Customer customer) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermsOfReference that = (TermsOfReference) o;

        if (getId() != that.getId()) return false;
        if (getCustomer() != null ? !getCustomer().equals(that.getCustomer()) : that.getCustomer() != null)
            return false;
        return getTasks() != null ? getTasks().equals(that.getTasks()) : that.getTasks() == null;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "TermsOfReference{" +
                "id=" + id +
                ", customer=" + customer +
                ", tasks=" + Arrays.deepToString(tasks.toArray()) +
                '}';
    }
}
