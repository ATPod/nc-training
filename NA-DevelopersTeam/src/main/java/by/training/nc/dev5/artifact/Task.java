package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Qualification;

import java.util.Map;

/**
 * Created by Nikita on 21.03.2017.
 */
public class Task {
    private Map<Qualification, Integer> quota;
    private String specification;

    /**
     * Gets the value of specification
     *
     * @return the value of specification.
     */
    public String getSpecification() {
        return specification;
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
     * Gets the value of quota
     *
     * @return the value of quota.
     */
    public Map<Qualification, Integer> getQuota() {
        return quota;
    }

    /**
     * Sets the value of quota
     *
     * @param quota the new value of quota.
     */
    public void setQuota(Map<Qualification, Integer> quota) {
        this.quota = quota;
    }
}
