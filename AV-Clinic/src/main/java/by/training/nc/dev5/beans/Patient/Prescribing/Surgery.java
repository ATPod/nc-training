package by.training.nc.dev5.beans.patient.prescribing;

import java.io.Serializable;

/**
 * Created by user on 17.03.2017.
 * * This class describes entity <b>Surgery</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Surgery extends AbstractPrescribing implements Serializable {
    /**
     * Creates new entity of the class <b>{@code Surgery}</b> and initialize it
     * @param name 						- name of surgery
     */
    public Surgery(String name) {
        super(name);
    }
}
