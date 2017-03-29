package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;

import java.util.*;

/**
 * The class {@code ConsoleOperations} contains methods for performing
 * operations with console.
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 *
 */
public class ConsoleOperations {
    public static Scanner input = new Scanner(System.in);

    /**
     * Array input from console
     * @return array of numbers
     */
    public static List<Integer> inputArray() {
        List<Integer> result = new ArrayList<>();
        input = new Scanner(System.in);
        String stringArray = input.next();
        String[] stringNumbers = stringArray.split(" ");
        for (String number : stringNumbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    /**
     * Number input from console
     * @return number
     */
    public static int inputNumber() {
        int number = -1;
        while (number < 0) {
            try {
                input = new Scanner(System.in);
                number = input.nextInt();
                if (number > 0) {
                    return number;
                }

            } catch (InputMismatchException e) {
                System.out.println("Неверный формат. Повторите ввод...");
            }
        }
        return 0;
    }

    /**
     * String input from console
     * @return string
     */
    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();

    }

    /**
     * Tutor object input from console
     * @return new instance of Tutor object
     */
    public static Tutor inputTutor() {
        System.out.println("Введите Ваше имя");
        String name = input.next();
        System.out.println("Введите Вашу фамилию");
        String surname = input.next();
        System.out.println("Введите Ваш предмет");
        String subject = input.next();
        return new Tutor((int) (Math.random() * 1000), name, surname, subject);

    }

    /**
     * Student object input from console
     * @return new instance of Student object
     */
    public static Student inputStudent() {
        System.out.println("Введите Ваше имя");
        String name = input.next();
        System.out.println("Введите Вашу фамилию");
        String surname = input.next();
        return new Student((int) (Math.random() * 1000), name, surname, 0);
    }

    /**
     * Question object input from console
     * @return new instance of Question object
     */
    public static Question inputQuestion() {
     return null;
    }

}
