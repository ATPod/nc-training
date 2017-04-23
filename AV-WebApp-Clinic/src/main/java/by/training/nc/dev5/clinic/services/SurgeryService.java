package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Surgery;
import by.training.nc.dev5.clinic.dao.SurgeryMySQLDAO;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class SurgeryService {

    public static List<Surgery> getByPatientId(int patientId) {
        return SurgeryMySQLDAO.INSTANCE.getByPatientId(patientId);
    }

    public static void add(Surgery surgery){
        SurgeryMySQLDAO.INSTANCE.add(surgery);
    }

    public static void delete(int id){
        SurgeryMySQLDAO.INSTANCE.delete(id);
    }
}
