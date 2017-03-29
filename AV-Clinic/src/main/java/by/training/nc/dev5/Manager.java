package by.training.nc.dev5;

import by.training.nc.dev5.beans.patient.*;
import by.training.nc.dev5.beans.patient.prescribing.*;
import by.training.nc.dev5.dao.interfaces.*;
import by.training.nc.dev5.utils.*;
import by.training.nc.dev5.factory.*;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Contains business logic
 * @author varchenko
 * @version 1.0
 *
 */
public final class Manager {
    private static List<Patient> patients;
    public static StringBuffer folder = new StringBuffer();
    private static final Logger log = Logger.getLogger(Manager.class);
    private static PatientDAO patientDAO;
    private static DiagnosisDAO diagnosisDAO;
    private static DrugDAO drugDAO;
    private static ProcedureDAO procedureDAO;
    private static SurgeryDAO surgeryDAO;

    /**
     * Initialization
     */
    public static void initialization(){
        folder.append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("resources")
                .append(File.separator)
                .append("by")
                .append(File.separator)
                .append("training")
                .append(File.separator)
                .append("nc")
                .append(File.separator)
                .append("dev5")
                .append(File.separator)
                .append("patients")
                .append(File.separator);
        DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        patientDAO = mySqlDAOFactory.getPatientDAO();
        diagnosisDAO = mySqlDAOFactory.getDiagnosisDAO();
        drugDAO = mySqlDAOFactory.getDrugDAO();
        procedureDAO = mySqlDAOFactory.getProcedureDAO();
        surgeryDAO = mySqlDAOFactory.getSurgeryDAO();

        //patients = createPatients();
        patients = patientDAO.selectPatients();
        fillPatientListFields();
    }

    /**
     * Create new list of patients or load from file
     * @return list of patients
     */
    private static List<Patient> createPatients(){

        try{
            FileInputStream ifStream = new FileInputStream(new File(folder.toString()+"patient0.txt"));
            patients= Operations.readFiles(folder.toString());
            ifStream.close();

        }catch(FileNotFoundException e){
            patients = new ArrayList<Patient>();
        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return patients;
    }

    private static void fillPatientListFields(){

    }
    /**
     * Show patients on the console
     */
    private static void showPatients(){
        for(int i=0;i<patients.size();i++){
            log.info(i+1+". "+patients.get(i).getName());
        }
    }

    /**
     * Show prescribed drugs of patient on the console
     * @param patientId id of patient
     */
    private static void showDrugs(int patientId) {
        for(int i=0;i<patients.get(patientId).getDrugs().size();i++){
            log.info(i+1+". "+patients.get(patientId).getDrugs().get(i).getName());
        }
    }

    /**
     * Show prescribed procedures of patient on the console
     * @param patientId id of patient
     */
    private static void showProcedures(int patientId) {
        for(int i=0;i<patients.get(patientId).getProcedures().size();i++){
            log.info(i+1+". "+patients.get(patientId).getProcedures().get(i).getName());
        }
    }

    /**
     * Show prescribed surgeries of patient on the console
     * @param patientId id of patient
     */
    private static void showSurgeries(int patientId) {
        for(int i=0;i<patients.get(patientId).getSurgeries().size();i++){
            log.info(i+1+". "+patients.get(patientId).getSurgeries().get(i).getName());
        }
    }

    /**
     * Correct file names during deleting one of them
     * @param patientId id of patient
     */
    private static void correctFileNames(int patientId){
        for(int i=patientId;i<patients.size()-1;i++){
            Operations.writeToFile(patients.get(i+1),new File(folder.toString() + "patient" + i + ".txt"));

        }
    }

    /**
     * Menu available to doctor
     */
    private static void doctorMenu(){
        out:
        while(true) {
            log.info("===========================================================");
            log.info("1. Выбрать пациента");
            log.info("2. Добавить пациента");
            log.info("0. Назад");
            log.info("===========================================================");
            switch(Operations.inputNumber()) {
                case 1:
                    doctorInnerMenu();
                    break;
                case 2:
                    addPatient();
                    break;
                case 0:
                    log.info("===========================================================");
                    break out;
                default:
                    log.info("===========================================================");
                    log.info("Неверный выбор либо формат. Повторите...");
            }
        }

    }

    /**
     * Add new patient to list
     */
    private static void addPatient() {
        log.info("Введите Фамилию");
        Patient tempPat = new Patient(Operations.inputString());
        patients.add(tempPat);
        Operations.writeToFile(tempPat,new File(folder.toString() + "patient" + (patients.size()-1) + ".txt"));
        log.info("Пациент добавлен");
    }

    /**
     * Add new diagnosis to patient
     * @param patientId id of patient
     */
    private static void addDiagnosis(int patientId){
        log.info("Введите диагноз:");
        Diagnosis tempDiagnosis = new Diagnosis(Operations.inputString());
        List<Diagnosis> tempDiagnosisList = patients.get(patientId).getDiagnosises();
        if(tempDiagnosisList==null)
        {
            tempDiagnosisList=new ArrayList<Diagnosis>();
        }
        tempDiagnosisList.add(tempDiagnosis);
        patients.get(patientId).setDiagnosises(tempDiagnosisList);
        Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
        log.info("Диагноз записан");
    }

    /**
     * Prescribe new drug to patient
     * @param patientId id of patient
     */
    private static void addDrug(int patientId){
        log.info("Введите название лекарства:");
        Drug tempDrug = new Drug(Operations.inputString());
        List<Drug> tempDrugList = patients.get(patientId).getDrugs();
        if(tempDrugList==null)
        {
            tempDrugList=new ArrayList<Drug>();
        }
        tempDrugList.add(tempDrug);
        patients.get(patientId).setDrugs(tempDrugList);
        Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
        log.info("Лекарство записано");
    }

    /**
     * Prescribe new procedure to patient
     * @param patientId id of patient
     */
    private static void addProcedure(int patientId){
        log.info("Введите название процедуры:");
        Procedure tempProcedure = new Procedure(Operations.inputString());
        List<Procedure> tempProcedureList = patients.get(patientId).getProcedures();
        if(tempProcedureList==null)
        {
            tempProcedureList=new ArrayList<Procedure>();
        }
        tempProcedureList.add(tempProcedure);
        patients.get(patientId).setProcedures(tempProcedureList);
        Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
        log.info("Процедура записана");
    }

    /**
     * Prescribe new surgery to patient
     * @param patientId id of patient
     */
    private static void addSurgery(int patientId){
        log.info("Введите название операции:");
        Surgery tempSurgery = new Surgery(Operations.inputString());
        List<Surgery> tempSurgeryList = patients.get(patientId).getSurgeries();
        if(tempSurgeryList==null)
        {
            tempSurgeryList=new ArrayList<Surgery>();
        }
        tempSurgeryList.add(tempSurgery);
        patients.get(patientId).setSurgeries(tempSurgeryList);
        Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
        log.info("Операция записана");
    }

    /**
     * Delete patient from list
     * @param patientId id of patient
     */
    private static void delPatient(int patientId){
        correctFileNames(patientId);
        File tempFile = new File(folder.toString() + "patient" + (patients.size()-1) + ".txt");
        boolean b = tempFile.delete();
        patients.remove(patientId);
    }

    /**
     * Delete drug from patient's prescribings
     * @param patientId id of patient
     */
    private static void delDrug(int patientId){
        if(patients.get(patientId).getDrugs().size()==0) {
            log.info("Нет прописанных лекарств");

        }else {
            showDrugs(patientId);
            int drugId = Operations.inputNumber()-1;
            List<Drug> tempDrugList = patients.get(patientId).getDrugs();
            tempDrugList.remove(drugId);
            patients.get(patientId).setDrugs(tempDrugList);
            Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
            log.info("Приём лекарства проведен");
        }
    }

    /**
     * Delete procedure from patient's prescribings
     * @param patientId id of patient
     */
    private static void delProcedure(int patientId){
        if(patients.get(patientId).getProcedures().size()==0) {
            log.info("Нет прописанных процедур");
        }else{
            showProcedures(patientId);
            int procedureId = Operations.inputNumber()-1;
            List<Procedure> tempProcedureList = patients.get(patientId).getProcedures();
            tempProcedureList.remove(procedureId);
            patients.get(patientId).setProcedures(tempProcedureList);
            Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
            log.info("Процедура проведена");
        }
    }

    /**
     * Delete surgery from patient's prescribings
     * @param patientId id of patient
     */
    private static void delSurgery(int patientId){
        if(patients.get(patientId).getSurgeries().size()==0) {
            log.info("Нет прописанных операций");
        } else{
            showSurgeries(patientId);
            int surgeryId = Operations.inputNumber()-1;
            List<Surgery> tempSurgeryList = patients.get(patientId).getSurgeries();
            tempSurgeryList.remove(surgeryId);
            patients.get(patientId).setSurgeries(tempSurgeryList);
            Operations.writeToFile(patients.get(patientId),new File(folder.toString() + "patient" + patientId + ".txt"));
            log.info("Операция проведена");
        }
    }

    /**
     * Deleting prescribings menu available to doctor
     * @param patientId id of patient
     */
    private static void delPrescribingMenu(int patientId){
        delPrescribings:
        while(true){
            log.info("===========================================================");
            log.info("1. Ввести лекарство");
            log.info("2. Сделать процедуру");
            log.info("3. Сделать операцию");
            log.info("0. Назад");
            log.info("===========================================================");
            switch(Operations.inputNumber()){
                case 1:
                    delDrug(patientId);
                    break;

                case 2:
                    delProcedure(patientId);
                    break;

                case 3:
                    delSurgery(patientId);
                    break;

                case 0:
                    break delPrescribings;

                default:
                    log.info("Неверный выбор. Повторите");
            }
        }
    }

    /**
     * Addition prescribings menu available to doctor
     * @param patientId id of patient
     */
    private static void addPrescribingMenu(int patientId) {
        addPrescribings:
        while(true){
            log.info("===========================================================");
            log.info("1. Определить лекарство");
            log.info("2. Определить процедуру");
            log.info("3. Определить операцию");
            log.info("0. Назад");
            log.info("===========================================================");
            switch(Operations.inputNumber()){
                case 1:
                    addDrug(patientId);
                    break;

                case 2:
                    addProcedure(patientId);
                    break;

                case 3:
                    addSurgery(patientId);
                    break;

                case 0:
                    break addPrescribings;

                default:
                    log.info("Неверный выбор. Повторите");
            }
        }
    }

    /**
     * Inner menu available to doctor
     */
    private static void doctorInnerMenu(){
        out:
        if(patients.size()==0){
            log.info("Нет пациентов");
        }else{
            showPatients();
            int patientId = Operations.inputNumber()-1;
            while(true){
                log.info("===========================================================");
                log.info("1. Определить диагноз");
                log.info("2. Определить назначение");
                log.info("3. Выполнить назначение");
                log.info("4. Выписать (удалить) пациента");
                log.info("0. Назад");
                log.info("===========================================================");
                switch(Operations.inputNumber()){
                    case 1:
                        addDiagnosis(patientId);
                        break;

                    case 2:
                        addPrescribingMenu(patientId);
                        break;

                    case 3:
                        delPrescribingMenu(patientId);
                        break;

                    case 4:
                        delPatient(patientId);
                        break out;

                    case 0:
                        break out;

                    default:
                        log.info("Неверный выбор. Повторите");
                }
            }

        }
    }

    /**
     * Menu available to nurse
     */
    private static void nurseMenu(){
        out:
        if(patients.size()==0){
            log.info("Нет пациентов");

        }else {
            showPatients();
            int patientId = Operations.inputNumber()-1;
            while(true){
                log.info("===========================================================");
                log.info("1. Ввести лекарство");
                log.info("2. Сделать процедуру");
                log.info("0. Назад");
                log.info("===========================================================");
                switch(Operations.inputNumber()){
                    case 1:
                        delDrug(patientId);
                        break;

                    case 2:
                        delProcedure(patientId);
                        break;

                    case 0:
                        break out;

                    default:
                        log.info("Неверный выбор. Повторите");
                }
            }
        }
    }

    /**
     * Main menu (login)
     */
    public static void mainMenu(){
        while(true){
            log.info("===========================================================");
            log.info("Выберите пользователя:");
            log.info("1. Врач");
            log.info("2. Медсестра");
            log.info("0. Выход");
            log.info("===========================================================");

            switch (Operations.inputNumber()) {
                case 1:
                    doctorMenu();
                    break;

                case 2:
                    nurseMenu();
                    break;

                case 0:
                    log.info("===========================================================");
                    log.info("Работа завершена...");
                    log.info("===========================================================");
                    System.exit(0);

                default:
                    log.info("===========================================================");
                    log.info("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}