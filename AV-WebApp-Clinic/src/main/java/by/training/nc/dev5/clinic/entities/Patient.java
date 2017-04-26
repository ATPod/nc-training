package by.training.nc.dev5.clinic.entities;

import javax.persistence.*;
import java.util.List;

@NamedQueries({@NamedQuery(name = "Patient.findAll", query = "SELECT o FROM Patient o"),
               @NamedQuery(name = "Patient.getByName", query = "SELECT a FROM Patient a WHERE a.name=?1")})
/**
 * Created by user on 25.04.2017.
 */
@Entity
public class Patient {
    private int id;
    private String name;
    private List<Diagnosis> diagnosises;
    private List<Drug> drugs;
    private List<MedProcedure> medProcedures;
    private List<Surgery> surgeries;

    @Id
    @Column(name = "PatientId")
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

    @OneToMany(mappedBy = "patient")
    public List<Diagnosis> getDiagnosises() {
        return diagnosises;
    }

    public void setDiagnosises(List<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
    }

    @OneToMany(mappedBy = "patient")
    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    @OneToMany(mappedBy = "patient")
    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @OneToMany(mappedBy = "patient")
    public List<MedProcedure> getMedProcedures() {
        return medProcedures;
    }

    public void setMedProcedures(List<MedProcedure> medProcedures) {
        this.medProcedures = medProcedures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != patient.id) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
