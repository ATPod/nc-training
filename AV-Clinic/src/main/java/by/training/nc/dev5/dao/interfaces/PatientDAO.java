package by.training.nc.dev5.dao.interfaces;

/**
 * Created by user on 28.03.2017.
 */
import java.util.List;

import by.training.nc.dev5.beans.patient.Patient;
public interface PatientDAO {
    int insertPatient(Patient patient);
    boolean deletePatient(int patientId);
    Patient findPatient(int patientId);
    boolean updatePatient(int patientId);
    List<Patient> selectPatients();
}
