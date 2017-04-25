package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.PatientMySQLDAO;
import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class PatientService {
    public static List<Patient> getAll(){
        return PatientMySQLDAO.INSTANCE.getAll();
    }

    public static boolean isNewPatient(String name){
        return (PatientMySQLDAO.INSTANCE.getByName(name)==null);
    }

    public static void add(Patient patient){
        PatientMySQLDAO.INSTANCE.add(patient);
    }

    public static Patient getById(int patientId) {
        return PatientMySQLDAO.INSTANCE.getById(patientId);
    }

    public static void delete(int patientId){
        PatientMySQLDAO.INSTANCE.delete(patientId);
    }
}
