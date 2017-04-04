package by.training.nc.dev5.entity;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Developer {
    private int id;
    private String name;
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
     * Gets the value of name
     *
     * @return the value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of name
     *
     * @param name the new value of name.
     */
    public void setName(String name) {
        this.name = name;
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
