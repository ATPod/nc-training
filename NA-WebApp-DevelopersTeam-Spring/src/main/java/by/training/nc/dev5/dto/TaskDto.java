package by.training.nc.dev5.dto;

import by.training.nc.dev5.entity.Qualification;

import java.util.Map;

/**
 * Created by Nikita on 08.05.2017.
 */
public class TaskDto {
    private String specification;
    private Map<QualificationDto, Integer> quotas;

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
     * Gets the value of quotas
     *
     * @return the value of quotas.
     */
    public Map<QualificationDto, Integer> getQuotas() {
        return quotas;
    }

    /**
     * Sets the value of quotas
     *
     * @param quotas the new value of quotas.
     */
    public void setQuotas(Map<QualificationDto, Integer> quotas) {
        this.quotas = quotas;
    }
}
