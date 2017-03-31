package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.patient.prescribing.Drug;
import by.training.nc.dev5.dao.DrugMySQLDAO;
import by.training.nc.dev5.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.utils.InputUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by user on 31.03.2017.
 */
public class DrugService {
    private static final Logger log = Logger.getLogger(DrugService.class);
    private static PrescribingDAO drugDAO = new DrugMySQLDAO();

    public static void add(int patientId){
        log.info("Введите название лекарства:");
        drugDAO.add(InputUtil.inputString(), patientId);
        log.info("Название лекарства записано");
    }

    public static void delete(int id){
        drugDAO.delete(id);
    }

    public static int determineId(int drugNumber, int patientId){
        List<Drug> drugs = (List<Drug>)drugDAO.getByPatientId(patientId);
        return drugs.get(drugNumber).getId();
    }

    public static void show(int patientId){
        List<Drug> drugs = (List<Drug>)drugDAO.getByPatientId(patientId);
        for(int i=0;i<drugs.size();i++){
            log.info(i+1+". "+drugs.get(i).getName());
        }
    }

    public static List<Drug> getByPatientId(int patientId){
        return (List<Drug>)drugDAO.getByPatientId(patientId);
    }
}
