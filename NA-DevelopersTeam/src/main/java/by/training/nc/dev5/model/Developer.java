package by.training.nc.dev5.model;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Developer {
    private int id;
    private Qualification qualification;
    private boolean isAssignedToProject;

    /**
     * Gets the value of qualification
     *
     * @return the value of qualification.
     */
    public Qualification getQualification() {
        return qualification;
    }

    /**
     * Sets the value of qualification
     *
     * @param qualification the new value of qualification.
     */
    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    /**
     * Gets the value of isAssignedToProject
     *
     * @return the value of isAssignedToProject.
     */
    public boolean isAssignedToProject() {
        return isAssignedToProject;
    }

    /**
     * Sets the value of isAssignedToProject
     *
     * @param isAssigned the new value of isAssignedToProject.
     */
    public void setAssignedToProject(boolean isAssigned) {
        this.isAssignedToProject = isAssigned;
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
