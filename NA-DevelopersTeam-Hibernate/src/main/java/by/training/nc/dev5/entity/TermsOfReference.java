package by.training.nc.dev5.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
@Entity
public class TermsOfReference {
    @Id
    private int id;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "termsOfReference")
    private Collection<Task> tasks;
    @OneToOne(mappedBy = "termsOfReference")
    private Project project;

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
     * Gets the value of tasks
     *
     * @return the value of tasks.
     */
    public Collection<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets the value of tasks
     *
     * @param tasks the new value of tasks.
     */
    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets the value of project
     *
     * @return the value of project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Sets the value of project
     *
     * @param project the new value of project.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "TermsOfReference{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}
