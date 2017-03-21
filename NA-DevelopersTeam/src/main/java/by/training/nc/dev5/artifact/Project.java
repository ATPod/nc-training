package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Developer;

import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Project {
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

}
