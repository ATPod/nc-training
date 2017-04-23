package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.clinic.dao.ProcedureMySQLDAO;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class ProcedureService {

    public static List<Procedure> getByPatientId(int patientId){
        return ProcedureMySQLDAO.INSTANCE.getByPatientId(patientId);
    }

    public static void delete(int id){
        ProcedureMySQLDAO.INSTANCE.delete(id);
    }

    public static void add(Procedure procedure){
        ProcedureMySQLDAO.INSTANCE.add(procedure);
    }
}
