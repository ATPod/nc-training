package by.training.nc.dev5.clinic.beans.patient.prescribing;


import by.training.nc.dev5.clinic.beans.Entity;

/**
 * This class describes abstract entity <b>Prescribing</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Prescribing extends Entity {

    private String name;
    private int patientId;

    public Prescribing() {
        super();
    }
    /**
     * Creates new entity of the class <b>{@code Prescribing}</b> and initialize it
     * @param name 						- name of prescribing
     */
    public Prescribing(String name) {
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Prescribing that = (Prescribing) o;

        if (patientId != that.patientId) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + patientId;
        return result;
    }

    @Override
    public String toString() {
        return  name;
    }
}
