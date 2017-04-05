package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.patient.prescribing.Surgery;
import by.training.nc.dev5.dao.SurgeryMySQLDAO;
import by.training.nc.dev5.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.utils.InputUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by user on 31.03.2017.
 */
public class SurgeryService {
    private static final Logger log = Logger.getLogger(SurgeryService.class);
    private static PrescribingDAO surgeryDAO = new SurgeryMySQLDAO();

    public static void add(int patientId){
        log.info("Введите название операции:");
        surgeryDAO.add(InputUtil.inputString(), patientId);
        log.info("Название операции записано");
    }

    public static void delete(int patientId){
        surgeryDAO.delete(patientId);
    }

    public static int determineId(int drugNumber, int patientId){
        List<Surgery> surgeries = (List<Surgery>)surgeryDAO.getByPatientId(patientId);
        return surgeries.get(drugNumber).getId();
    }

    public static void show(int patientId){
        List<Surgery> surgeries = (List<Surgery>)surgeryDAO.getByPatientId(patientId);
        for(int i=0;i<surgeries.size();i++){
            log.info(i+1+". "+surgeries.get(i).getName());
        }
    }

    public static List<Surgery> getByPatientId(int patientId){
        return (List<Surgery>)surgeryDAO.getByPatientId(patientId);
    }
}

