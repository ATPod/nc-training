package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.patient.prescribing.Prescribing;
import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.dao.interfaces.*;
import by.training.nc.dev5.beans.patient.Patient;
import by.training.nc.dev5.utils.InputUtil;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by user on 30.03.2017.
 */
public class PatientService {

    private static final Logger log = Logger.getLogger(PatientService.class);
    private static PatientDAO patientDAO = new PatientMySQLDAO();

    public static List<Patient> getAll(){
        return patientDAO.getAll();
    }

    public static Patient getById(int patientId){
        return patientDAO.getById(patientId);
    }

    public static void add(){
        log.info("Введите Фамилию:");
        patientDAO.add(InputUtil.inputString());
        log.info("Пациент добавлен");
    }

    public static void show(){
        List<Patient> patients = getAll();
        for(int i=0;i<patients.size();i++){
            log.info(i+1+". "+patients.get(i).getName());
        }
    }

    public static int determineId(int patientNumber){
        List<Patient> patients = getAll();
        return patients.get(patientNumber).getId();
    }

    public static void delete(int patientId){
        patientDAO.delete(patientId);
        log.info("Пациент выписан (удалён)");
    }
}
