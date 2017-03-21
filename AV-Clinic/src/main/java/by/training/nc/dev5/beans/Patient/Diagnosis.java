package by.training.nc.dev5.beans.Patient;

import java.io.Serializable;

/**
 * Created by user on 17.03.2017.
 * * This class describes entity <b>Diagnosis</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Diagnosis implements Serializable{
    private String name;

    /**
     * Creates new entity of the class <b>{@code Diagnosis}</b> and initialize it
     * @param name 						- name of diagnosis
     */
    public Diagnosis(String name) {
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

        Diagnosis diagnosis = (Diagnosis) o;

        return !(name != null ? !name.equals(diagnosis.name) : diagnosis.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
