package by.training.nc.dev5.utils;


import java.util.*;
import org.apache.log4j.Logger;

/**
 * Created by user on 17.03.2017
 * The class {@code InputUtil} contains methods for performing
 * operations with database of services.
 *
 * @author varchenko
 * @version 1.0
 *
 */
public final class InputUtil {

    public static Scanner input = new Scanner(System.in);
    private static final Logger log = Logger.getLogger(InputUtil.class);

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


}