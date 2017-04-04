package by.training.nc.dev5.beans.patient.prescribing;

import java.io.Serializable;

/**
 * Created by user on 17.03.2017.
 * * This class describes entity <b>Procedure</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Procedure extends Prescribing implements Serializable {

    public Procedure(){
        super();
    }
    /**
     * Creates new entity of the class <b>{@code Procedure}</b> and initialize it
     * @param name 						- name of procedure
     */
    public Procedure(String name) {
        super(name);
    }
}
