package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class TermsOfReference {
    private int id;
    private int customerId;

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
     * Gets the value of customerId
     *
     * @return the value of customerId.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of customerId
     *
     * @param customerId the new value of customerId.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the value of managerId
     *
     * @return the value of managerId.
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * Sets the value of managerId
     *
     * @param managerId the new value of managerId.
     */
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    private int managerId;
}
