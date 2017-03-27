package by.training.nc.dev5.tools;


import by.training.nc.dev5.beans.patient.Patient;

import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by user on 17.03.2017
 * The class {@code Operations} contains methods for performing
 * operations with database of services.
 *
 * @author varchenko
 * @version 1.0
 *
 */
public final class Operations {

    public static Scanner input = new Scanner(System.in);
    private static final Logger log = Logger.getLogger(Operations.class);

    /**
     * Checks the right input of numbers
     * @return integer number above zero
     */
    public static int inputNumber() {
        int number = -1;
        while (number < 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if (number >= 0) {
                    return number;
                } else {
                    log.info("Параметр не может быть отрицательным. Повторите ввод...");
                    continue;
                }

            } catch (InputMismatchException e) {
                log.info("Неверный формат. Повторите ввод...");
                log.error(e.getMessage(), e);
                continue;
            }
        }
        return 0;
    }

    /**
     * String input
     * @return string
     */
    public static String inputString(){
        while (true) {

            input = new Scanner(System.in);
            String str=input.next();
            if (!str.equals("")) {
                return str;
            } else {
                log.info("Вы ничего не ввели.");
            }
        }
    }

    /**
     * Write patient to file
     * @param patient
     * @param file
     */
    public static void writeToFile(Patient patient, File file){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(patient);
            //System.out.println("Запись успешно произведена в файл \"" + file.getName() + "\"");
        }
        catch (IOException e) {
            log.info("Ошибка записи. Невозможно создать файл \"" + file.getName() + "\"");
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Read all files from folder
     * @param folder
     * @return list of patients
     */
    public static List<Patient> readFiles(String folder){
        List<Patient> fromFile = new ArrayList<Patient>();
        try {
            int i=0;
            while(true){
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(folder + "patient" + i +".txt")));
                fromFile.add((Patient) ois.readObject());
                i++;
            }
        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        catch (ClassNotFoundException e) {
            log.info("Класс не найден...");
            log.error(e.getMessage(), e);
        }
        return fromFile;
    }

}