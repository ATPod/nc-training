package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.Diagnosis;
import by.training.nc.dev5.clinic.dao.DiagnosisMySQLDAO;
import by.training.nc.dev5.clinic.entities.Patient;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DiagnosisService {
    public static List<Diagnosis> getByPatient(Patient patient){
        return DiagnosisMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void add(Diagnosis diagnosis){
        DiagnosisMySQLDAO.INSTANCE.add(diagnosis);
    }

    public static void delete(int id){
        DiagnosisMySQLDAO.INSTANCE.delete(id);
    }
}
