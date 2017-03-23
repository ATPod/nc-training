package by.training.nc.dev5.model;

import by.training.nc.dev5.artifact.Project;

/**
 * Represents Developer entity
 *
 * @author Nikita Atroshenko
 */
public class Developer {
    private int id;
    private Qualification qualification;
    private Project project;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (getId() != developer.getId()) return false;
        if (getQualification() != developer.getQualification()) return false;
        return getProject() != null ? getProject().equals(developer.getProject()) : developer.getProject() == null;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
