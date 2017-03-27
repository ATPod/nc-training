package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;

import java.util.*;

/**
 * Created by NotePad.by on 18.03.2017.
 */
public class ConsoleOperations {
    public static Scanner input = new Scanner(System.in);

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

    public static String inputString() {
        input = new Scanner(System.in);
        return input.next();

    }

    public static Tutor inputTutor() {
        System.out.println("Введите Ваше имя");
        String name = input.next();
        System.out.println("Введите Вашу фамилию");
        String surname = input.next();
        System.out.println("Введите Ваш предмет");
        String subject = input.next();
        return new Tutor((int) (Math.random() * 1000), name, surname, subject);

    }

    public static Student inputStudent() {
        System.out.println("Введите Ваше имя");
        String name = input.next();
        System.out.println("Введите Вашу фамилию");
        String surname = input.next();
        return new Student((int) (Math.random() * 1000), name, surname, 0);
    }

    public static Question inputQuestion() {
        input = new Scanner(System.in);
        System.out.println("Введите текст вопроса: ");
        String subject = input.next();
        System.out.println("Введите баллы за вопрос");
        int balls;
        while (true) {
            try {
                balls = inputNumber();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Повторите...");
                continue;
            }
            break;
        }
        System.out.println("Введите количество вариантов ответа");
        int variantAmount;
        while (true) {
            try {
                variantAmount = inputNumber();
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Повторите...");
                continue;
            }
            break;
        }
        Map<Integer, String> variants = new HashMap<>();
        for (int i = 0; i < variantAmount; i++) {
            System.out.println("Введите вариант ответа №" + (i + 1));
            String variant = input.next();
            variants.put(i + 1, variant);
        }
        System.out.println("Введите номера правильных вариантов ответа");
        List<Integer> rightAnswers = inputArray();
        return new Question(subject, balls, variants, rightAnswers);
    }

}
