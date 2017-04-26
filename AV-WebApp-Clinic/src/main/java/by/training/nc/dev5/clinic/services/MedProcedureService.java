package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.MedProcedure;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.MedMedProcedureMySQLDAO;
import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class MedProcedureService {

    public static List<MedProcedure> getByPatient(Patient patient){
        return MedMedProcedureMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void delete(int id){
        MedMedProcedureMySQLDAO.INSTANCE.delete(id);
    }

    public static void add(MedProcedure medProcedure){
        MedMedProcedureMySQLDAO.INSTANCE.add(medProcedure);
    }
}
