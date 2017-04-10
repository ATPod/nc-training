package by.training.nc.dev5;

import by.training.nc.dev5.services.*;
import by.training.nc.dev5.utils.*;
import org.apache.log4j.Logger;

/**
 * Contains business logic
 * @author varchenko
 * @version 1.0
 *
 */
public final class Menu {

    private static final Logger log = Logger.getLogger(Menu.class);

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

            switch (InputUtil.inputNumber()) {
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
            switch(InputUtil.inputNumber()) {
                case 1:

                    doctorInnerMenu();
                    break;
                case 2:
                    PatientService.add();
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
     * Inner menu available to doctor
     */
    private static void doctorInnerMenu(){
        out:
        if(PatientService.getAll().size()==0){
            log.info("Нет пациентов");
        }else{
            PatientService.show();
            int patientId = PatientService.determineId( InputUtil.inputNumber()-1 );
            while(true){
                log.info("===========================================================");
                log.info("1. Определить диагноз");
                log.info("2. Определить назначение");
                log.info("3. Выполнить назначение");
                log.info("4. Выписать (удалить) пациента");
                log.info("0. Назад");
                log.info("===========================================================");
                switch(InputUtil.inputNumber()){
                    case 1:
                        DiagnosisService.add(patientId);
                        break;

                    case 2:
                        addPrescribingMenu(patientId);
                        break;

                    case 3:
                        delPrescribingMenu(patientId);
                        break;

                    case 4:
                        PatientService.delete(patientId);
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
            switch(InputUtil.inputNumber()){
                case 1:
                    DrugService.add(patientId);
                    break;

                case 2:
                    ProcedureService.add(patientId);
                    break;

                case 3:
                    SurgeryService.add(patientId);
                    break;

                case 0:
                    break addPrescribings;

                default:
                    log.info("Неверный выбор. Повторите");
            }
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
            switch(InputUtil.inputNumber()){
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
     * Menu available to nurse
     */
    private static void nurseMenu(){
        out:
        if(PatientService.getAll().size()==0){
            log.info("Нет пациентов");

        }else {
            PatientService.show();
            int patientId = PatientService.determineId( InputUtil.inputNumber()-1 );
            while(true){
                log.info("===========================================================");
                log.info("1. Ввести лекарство");
                log.info("2. Сделать процедуру");
                log.info("0. Назад");
                log.info("===========================================================");
                switch(InputUtil.inputNumber()){
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
     * Delete drug from patient's prescribings
     * @param patientId id of patient
     */
    private static void delDrug(int patientId){
        if(DrugService.getByPatientId(patientId).size()==0) {
            log.info("Нет прописанных лекарств");
        }else {
            DrugService.show(patientId);
            int drugId = DrugService.determineId( InputUtil.inputNumber()-1, patientId );
            DrugService.delete(drugId);
            log.info("Приём лекарства проведен");
        }
    }

    /**
     * Delete procedure from patient's prescribings
     * @param patientId id of patient
     */
    private static void delProcedure(int patientId){
        if(ProcedureService.getByPatientId(patientId).size()==0) {
            log.info("Нет прописанных процедур");
        }else {
            ProcedureService.show(patientId);
            int procedureId = ProcedureService.determineId( InputUtil.inputNumber()-1, patientId );
            ProcedureService.delete(procedureId);
            log.info("Приём процедуры проведен");
        }
    }

    /**
     * Delete surgery from patient's prescribings
     * @param patientId id of patient
     */
    private static void delSurgery(int patientId){
        if(SurgeryService.getByPatientId(patientId).size()==0) {
            log.info("Нет прописанных операций");
        }else {
            SurgeryService.show(patientId);
            int surgeryId = SurgeryService.determineId( InputUtil.inputNumber()-1, patientId );
            SurgeryService.delete(surgeryId);
            log.info("Операция проведена");
        }
    }
}