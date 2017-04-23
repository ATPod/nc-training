package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.patient.Patient;
import by.training.nc.dev5.clinic.dao.PatientMySQLDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class PatientService {
    public static List<Patient> getAll(){
        return PatientMySQLDAO.INSTANCE.getAll();
    }

    public static boolean isNewPatient(String name) throws SQLException {
        return PatientMySQLDAO.INSTANCE.isNewPatient(name);
    }

    public static void add(Patient patient) throws SQLException{
        PatientMySQLDAO.INSTANCE.add(patient);
    }

    public static Patient getById(int patientId){
        return PatientMySQLDAO.INSTANCE.getById(patientId);
    }

    public static void delete(int patientId) throws SQLException{
        PatientMySQLDAO.INSTANCE.delete(patientId);
    }
}
