package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.dao.ProcedureMySQLDAO;
import by.training.nc.dev5.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.utils.InputUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by user on 31.03.2017.
 */
public class ProcedureService {
    private static final Logger log = Logger.getLogger(ProcedureService.class);
    private static PrescribingDAO procedureDAO = new ProcedureMySQLDAO();

    public static void add(int patientId){
        log.info("Введите название процедуры:");
        procedureDAO.add(InputUtil.inputString(), patientId);
        log.info("Название процедуры записано");
    }

    public static void delete(int patientId){
        procedureDAO.delete(patientId);
    }

    public static int determineId(int drugNumber, int patientId){
        List<Procedure> procedures = (List<Procedure>)procedureDAO.getByPatientId(patientId);
        return procedures.get(drugNumber).getId();
    }

    public static void show(int patientId){
        List<Procedure> procedures = (List<Procedure>)procedureDAO.getByPatientId(patientId);
        for(int i=0;i<procedures.size();i++){
            log.info(i+1+". "+procedures.get(i).getName());
        }
    }

    public static List<Procedure> getByPatientId(int patientId){
        return (List<Procedure>)procedureDAO.getByPatientId(patientId);
    }
}
