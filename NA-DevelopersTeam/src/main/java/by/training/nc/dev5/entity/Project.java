package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Project {
    private int id;
    private int termsOfReferenceId;
    private int managerId;

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
     * Gets the value of termsOfReferenceId
     *
     * @return the value of termsOfReferenceId.
     */
    public int getTermsOfReferenceId() {
        return termsOfReferenceId;
    }

    /**
     * Sets the value of termsOfReferenceId
     *
     * @param termsOfReferenceId the new value of termsOfReferenceId.
     */
    public void setTermsOfReferenceId(int termsOfReferenceId) {
        this.termsOfReferenceId = termsOfReferenceId;
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
}
