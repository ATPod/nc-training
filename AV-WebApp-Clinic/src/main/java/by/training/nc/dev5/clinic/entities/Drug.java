package by.training.nc.dev5.clinic.entities;

import javax.persistence.*;

/**
 * Created by user on 25.04.2017.
 */
@NamedQueries({@NamedQuery(name = "Drug.getByPatient", query = "SELECT a FROM Drug a WHERE a.patient=?1")})

@Entity
public class Drug {
    private int id;
    private String name;
    private Patient patient;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        if (id != drug.id) return false;
        if (name != null ? !name.equals(drug.name) : drug.name != null) return false;
        return !(patient != null ? !patient.equals(drug.patient) : drug.patient != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        return result;
    }
}
