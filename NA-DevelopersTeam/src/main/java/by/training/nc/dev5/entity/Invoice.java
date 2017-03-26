package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Invoice {
    private int id;
    private int projectId;
    private double price;

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
     * Gets the value of projectId
     *
     * @return the value of projectId.
     */
    public int getProjectId() {
        return projectId;
    }

    /**
     * Sets the value of projectId
     *
     * @param projectId the new value of projectId.
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
}
