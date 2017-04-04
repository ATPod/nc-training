package by.training.nc.dev5.dao.interfaces;

/**
 * Created by user on 28.03.2017.
 */
import java.util.List;
import by.training.nc.dev5.beans.patient.Patient;

public interface PatientDAO {

    void add(String name);
    void delete(int patientId);
    List<Patient> getAll();
    Patient getById(int patientId);
}
