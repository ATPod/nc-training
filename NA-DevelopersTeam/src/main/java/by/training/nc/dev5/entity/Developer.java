package by.training.nc.dev5.entity;

import by.training.nc.dev5.accounts.UserRole;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Developer extends Person {
    private Qualification qualification;
    private Project project;

    public Developer() {
        setUserRole(UserRole.DEVELOPER);
    }

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
        return "Developer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", qualification=" + qualification +
                ", project=" + project +
                '}';
    }
}
