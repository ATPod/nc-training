package by.training.nc.dev5.beans.Patient.Prescribing;

import java.io.Serializable;

/**
 * Created by user on 17.03.2017.
 * This class describes entity <b>Drug</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Drug extends AbstractPrescribing implements Serializable {
    /**
     * Creates new entity of the class <b>{@code Drug}</b> and initialize it
     * @param name 						- name of drug
     */
    public Drug(String name) {
        super(name);
    }
}
