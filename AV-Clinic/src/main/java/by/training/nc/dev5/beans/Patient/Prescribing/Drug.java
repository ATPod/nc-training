package by.training.nc.dev5.beans.patient.prescribing;

import java.io.Serializable;

/**
 * Created by user on 17.03.2017.
 * This class describes entity <b>Drug</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Drug extends Prescribing implements Serializable {
    public Drug(){
        super();
    }
    /**
     * Creates new entity of the class <b>{@code Drug}</b> and initialize it
     * @param name 						- name of drug
     */
    public Drug(String name) {
        super(name);
    }
}
