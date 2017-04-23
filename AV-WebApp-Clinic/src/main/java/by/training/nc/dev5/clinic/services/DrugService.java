package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Drug;
import by.training.nc.dev5.clinic.dao.DrugMySQLDAO;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class DrugService {
    public static List<Drug> getByPatientId(int patientId){
        return DrugMySQLDAO.INSTANCE.getByPatientId(patientId);
    }

    public static void delete(int id){
        DrugMySQLDAO.INSTANCE.delete(id);
    }

    public static void add(Drug drug){
        DrugMySQLDAO.INSTANCE.add(drug);
    }

}
