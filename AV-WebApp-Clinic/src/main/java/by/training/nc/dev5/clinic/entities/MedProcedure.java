package by.training.nc.dev5.clinic.entities;

import javax.persistence.*;
/**
 * Created by user on 25.04.2017.
 */
@NamedQueries({@NamedQuery(name = "MedProcedure.getByPatient", query = "SELECT a FROM MedProcedure a WHERE a.patient=?1")})

@Entity
public class MedProcedure {
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

        MedProcedure medProcedure = (MedProcedure) o;

        if (id != medProcedure.id) return false;
        if (name != null ? !name.equals(medProcedure.name) : medProcedure.name != null) return false;
        return !(patient != null ? !patient.equals(medProcedure.patient) : medProcedure.patient != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        return result;
    }
}
