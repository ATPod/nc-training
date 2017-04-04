package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Invoice {
    private int id;
    private double price;
    private boolean paid;
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
     * Gets the value of paid
     *
     * @return the value of paid.
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Sets the value of paid
     *
     * @param paid the new value of paid.
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
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
