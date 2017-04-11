package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.beans.patient.Patient;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public interface PatientDAO {
    void add(Patient patient) throws SQLException;
    void delete(int patientId) throws SQLException;
    List<Patient> getAll();
    boolean isNewPatient(String name) throws SQLException;
    //Patient getById(int patientId);
}
