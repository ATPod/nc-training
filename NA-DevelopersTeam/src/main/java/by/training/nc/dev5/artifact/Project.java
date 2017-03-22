package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Developer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Project {
    private int id;
    private List<Developer> developers;
    private TermsOfReference termsOfReference;

    /**
     * Gets the value of developers
     *
     * @return the value of developers.
     */
    public List<Developer> getDevelopers() {
        return developers;
    }
    /**
     * Sets the value of developers
     *
     * @param developers the new value of developers.
     */
    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (getId() != project.getId()) return false;
        if (getDevelopers() != null ? !getDevelopers().equals(project.getDevelopers()) : project.getDevelopers() != null)
            return false;
        return getTermsOfReference() != null ? getTermsOfReference().equals(project.getTermsOfReference()) : project.getTermsOfReference() == null;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", developers=" + Arrays.deepToString(developers.toArray()) +
                ", termsOfReference=" + termsOfReference +
                '}';
    }
}
