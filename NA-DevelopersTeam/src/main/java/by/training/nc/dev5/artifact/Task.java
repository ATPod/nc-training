package by.training.nc.dev5.artifact;

import by.training.nc.dev5.model.Qualification;
import by.training.nc.dev5.util.MapPrinter;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (getQuota() != null ? !getQuota().equals(task.getQuota()) : task.getQuota() != null) return false;
        return getSpecification() != null ? getSpecification().equals(task.getSpecification()) : task.getSpecification() == null;
    }

    @Override
    public int hashCode() {
        int result = getQuota() != null ? getQuota().hashCode() : 0;
        result = 31 * result + (getSpecification() != null ? getSpecification().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "quota=" + new MapPrinter<>(quota) +
                ", specification='" + specification + '\'' +
                '}';
    }
}
