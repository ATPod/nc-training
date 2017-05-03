package by.training.nc.dev5.clinic.entities;

import javax.persistence.*;

/**
 * Created by user on 25.04.2017.
 */
@NamedQueries({@NamedQuery(name = "Surgery.getByPatient", query = "SELECT a FROM Surgery a WHERE a.patient=?1")})

@Entity
public class Surgery extends AbstractEntity{

    private String name;
    private Patient patient;

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "PatientId")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}
