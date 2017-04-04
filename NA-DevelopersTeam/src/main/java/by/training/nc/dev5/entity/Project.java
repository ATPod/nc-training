package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Project {
    private int id;
    private Manager manager;
    private TermsOfReference termsOfReference;

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
     * Gets the value of termsOfReference
     *
     * @return the value of termsOfReference.
     */
    public TermsOfReference getTermsOfReference() {
        return termsOfReference;
    }

    /**
     * Sets the value of termsOfReference
     *
     * @param termsOfReference the new value of termsOfReference.
     */
    public void setTermsOfReference(TermsOfReference termsOfReference) {
        this.termsOfReference = termsOfReference;
    }

    /**
     * Gets the value of manager
     *
     * @return the value of manager.
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * Sets the value of manager
     *
     * @param manager the new value of manager.
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
