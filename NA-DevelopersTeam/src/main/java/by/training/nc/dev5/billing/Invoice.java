package by.training.nc.dev5.billing;

import by.training.nc.dev5.artifact.Project;
import by.training.nc.dev5.model.Customer;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Invoice {
    private int id;
    private Customer customer;
    private Project project;
    private double price;

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
     * Gets the value of price
     *
     * @return the value of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of price
     *
     * @param price the new value of price.
     */
    public void setPrice(double price) {
        this.price = price;
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
}
