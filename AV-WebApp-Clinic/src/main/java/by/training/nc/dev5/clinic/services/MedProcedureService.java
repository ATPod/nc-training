package by.training.nc.dev5.clinic.services;

import by.training.nc.dev5.clinic.entities.prescribings.MedProcedure;
import by.training.nc.dev5.clinic.entities.Patient;
import by.training.nc.dev5.clinic.dao.impl.MedProcedureMySQLDAO;
import by.training.nc.dev5.clinic.exceptions.DAOException;

import java.util.List;

/**
 * Created by user on 22.04.2017.
 */
public class MedProcedureService {

    public static List<MedProcedure> getByPatient(Patient patient)throws DAOException {
        return MedProcedureMySQLDAO.INSTANCE.getByPatient(patient);
    }

    public static void delete(int id)throws DAOException{
        MedProcedureMySQLDAO.INSTANCE.delete(id);
    }

    public static void add(MedProcedure medProcedure)throws DAOException{
        MedProcedureMySQLDAO.INSTANCE.add(medProcedure);
    }
}
