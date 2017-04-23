package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.clinic.dao.DiagnosisMySQLDAO;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DiagnosisService {
    public static List<Diagnosis> getByPatientId(int patientId){
        return DiagnosisMySQLDAO.INSTANCE.getByPatientId(patientId);
    }

    public static void add(Diagnosis diagnosis){
        DiagnosisMySQLDAO.INSTANCE.add(diagnosis);
    }

    public static void delete(int id){
        DiagnosisMySQLDAO.INSTANCE.delete(id);
    }
}
