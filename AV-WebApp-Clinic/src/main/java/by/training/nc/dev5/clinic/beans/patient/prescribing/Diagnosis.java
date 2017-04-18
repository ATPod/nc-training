package by.training.nc.dev5.clinic.beans.patient.prescribing;


/**
 * Created by user on 17.03.2017.
 * * This class describes entity <b>Diagnosis</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Diagnosis extends Prescribing {

    public Diagnosis(){
        super();
    }
    /**
     * Creates new entity of the class <b>{@code Diagnosis}</b> and initialize it
     *
     * @param name - name of diagnosis
     */
    public Diagnosis(String name) {
        super(name);
    }
}