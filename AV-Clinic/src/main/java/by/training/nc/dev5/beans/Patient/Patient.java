package by.training.nc.dev5.beans.patient;


import by.training.nc.dev5.beans.patient.prescribing.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 17.03.2017.
 * * This class describes entity <b>Patient</b>
 *
 * @author varchenko
 * @version 1.0
 */
public class Patient implements Serializable{
    private String name;
    private List<Diagnosis> diagnosises;
    private List<Drug> drugs;
    private List<Procedure> procedures;
    private List<Surgery> surgeries;

    /**
     * Creates new entity of the class <b>{@code Patient}</b> and initialize it
     * @param name 						- name of patient
     */
    public Patient(String name) {
        this.name = name;
        this.diagnosises=new ArrayList<Diagnosis>();
        this.drugs=new ArrayList<Drug>();
        this.procedures=new ArrayList<Procedure>();
        this.surgeries=new ArrayList<Surgery>();
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

    /**
     *
     * @return list of diagnosises
     */
    public List<Diagnosis> getDiagnosises() {
        return diagnosises;
    }

    /**
     *
     * @param diagnosises list of diagnosises
     */
    public void setDiagnosises(List<Diagnosis> diagnosises) {
        this.diagnosises = diagnosises;
    }

    /**
     *
     * @return list o drugs
     */
    public List<Drug> getDrugs() {
        return drugs;
    }

    /**
     *
     * @param drugs list of drugs
     */
    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    /**
     *
     * @return list of procedures
     */
    public List<Procedure> getProcedures() {
        return procedures;
    }

    /**
     *
     * @param procedures list of procedures
     */
    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    /**
     *
     * @return list of surgeries
     */
    public List<Surgery> getSurgeries() {
        return surgeries;
    }

    /**
     *
     * @param surgeries list of surgeries
     */
    public void setSurgeries(List<Surgery> surgeries) {
        this.surgeries = surgeries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        if (diagnosises != null ? !diagnosises.equals(patient.diagnosises) : patient.diagnosises != null) return false;
        if (drugs != null ? !drugs.equals(patient.drugs) : patient.drugs != null) return false;
        if (procedures != null ? !procedures.equals(patient.procedures) : patient.procedures != null) return false;
        return !(surgeries != null ? !surgeries.equals(patient.surgeries) : patient.surgeries != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (diagnosises != null ? diagnosises.hashCode() : 0);
        result = 31 * result + (drugs != null ? drugs.hashCode() : 0);
        result = 31 * result + (procedures != null ? procedures.hashCode() : 0);
        result = 31 * result + (surgeries != null ? surgeries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", diagnosises=" + diagnosises +
                ", drugs=" + drugs +
                ", procedures=" + procedures +
                ", surgeries=" + surgeries +
                '}';
    }
}
