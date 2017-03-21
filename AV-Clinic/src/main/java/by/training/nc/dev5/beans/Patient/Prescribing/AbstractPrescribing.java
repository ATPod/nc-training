package by.training.nc.dev5.beans.Patient.Prescribing;

/**
 * This class describes abstract entity <b>AbstractPrescribing</b>
 *
 * @author varchenko
 * @version 1.0
 */
public abstract class AbstractPrescribing {

    private String name;

    /**
     * Creates new entity of the class <b>{@code AbstractPrescribing}</b> and initialize it
     * @param name 						- name of prescribing
     */
    public AbstractPrescribing(String name) {
        this.name = name;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPrescribing that = (AbstractPrescribing) o;

        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return  name;
    }
}
