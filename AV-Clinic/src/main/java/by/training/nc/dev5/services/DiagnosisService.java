package by.training.nc.dev5.services;

import by.training.nc.dev5.dao.DiagnosisMySQLDAO;
import by.training.nc.dev5.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.utils.InputUtil;
import org.apache.log4j.Logger;

/**
 * Created by user on 31.03.2017.
 */
public class DiagnosisService {
    private static final Logger log = Logger.getLogger(DiagnosisService.class);
    private static PrescribingDAO diagnosisDAO = new DiagnosisMySQLDAO();

    public static void add(int patientId){
        log.info("Введите диагноз:");
        diagnosisDAO.add(InputUtil.inputString(), patientId);
        log.info("Диагноз записан");
    }

    public static void delete(int patientId){
        diagnosisDAO.delete(patientId);
    }
}


