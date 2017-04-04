package by.training.nc.dev5.entity;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public class Task {
    private int id;
    private String specification;
    private TermsOfReference termsOfReference;
    private Collection<TaskQuota> taskQuotas;

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
     * Gets the value of specification
     *
     * @return the value of specification.
     */
    public String getSpecification() {
        return specification;
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
     * Sets the value of specification
     *
     * @param specification the new value of specification.
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * Gets the value of taskQuotas
     *
     * @return the value of taskQuotas.
     */
    public Collection<TaskQuota> getTaskQuotas() {
        return taskQuotas;
    }

    /**
     * Sets the value of taskQuotas
     *
     * @param taskQuotas the new value of taskQuotas.
     */
    public void setTaskQuotas(Collection<TaskQuota> taskQuotas) {
        this.taskQuotas = taskQuotas;
    }
}
