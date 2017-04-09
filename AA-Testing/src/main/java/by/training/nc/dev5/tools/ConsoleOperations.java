package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.beans.users.User;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.services.StudentService;
import by.training.nc.dev5.services.TutorService;
import by.training.nc.dev5.sql.SQLQueries;

import java.util.*;

public class ConsoleOperations {
    private static InterfaceDAO<Test> testDAO;
    private static Scanner input;

    static {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        testDAO = factory.getTestDAO();
        input = new Scanner(System.in);
    }

    /**
     * Array input from console
     *
     * @return array of numbers
     */
    private static List<Integer> inputArray() {
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
     *
     * @return number
     */
    private static int inputNumber() {
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
     *
     * @return string
     */
    private static String inputString() {
        input = new Scanner(System.in);
        return input.next();

    }

    private static User loginUser() {
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<User> userDAO = factory.getUserDAO();
        String login = null;
        String password = null;
        User user = null;
        while (true) {
            System.out.println("Введите логин пользователя...");
            login = inputString();
            System.out.println("Введите пароль пользователя...");
            password = inputString();
            List<User> loginUsers = userDAO.getAll(SQLQueries.FIND_BY_LOGIN_PASSWORD, login, password);
            if (loginUsers.size() != 0) {
                user = loginUsers.get(0);
                break;
            } else {
                System.out.println("Пользователя с данным логином и паролем нет в системе.  Повторите ввод... ");
            }
        }
        System.out.println("Добро пожаловать, " + user.getName() + " " + user.getSurname() + "!");
        return user;
    }

    /**
     * Question object input from console
     *
     * @return new instance of Question object
     */
    public static Question inputQuestion() {
        return null;
    }

    public static void consoleMenu() {
        while (true) {
            System.out.println("===========================================================");
            System.out.println("Выберите пользователя:");
            System.out.println("1. Tutor");
            System.out.println("2. Student");
            System.out.println("0. Выход");
            System.out.println("===========================================================");


            switch (ConsoleOperations.inputNumber()) {
                case 1:
                    Tutor tutor = (Tutor) ConsoleOperations.loginUser();
                    TutorService tutorService = TutorService.getInstance();
                    out:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показать список тестов");
                        System.out.println("2. Добавить тест в систему");

                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (ConsoleOperations.inputNumber()) {
                            case 1:
                                System.out.println("===========================================================");
                                System.out.println(testDAO.getAll().toString());
                                break;

                            case 2:
                                System.out.println("Введите название теста (одно слово без пробелов)");
                                String testName = ConsoleOperations.inputString();
                                System.out.println("Введите количество вопросов");
                                int questionAmount = 0;
                                while (true) {
                                    try {
                                        questionAmount = ConsoleOperations.inputNumber();
                                    } catch (InputMismatchException e) {
                                        System.out.println("Неверный ввод! Повторите...");
                                        continue;
                                    }
                                    break;
                                }
                                Test test = tutorService.creatingTest(tutor, testName, questionAmount);
                                testDAO.insert(test);
                                System.out.println(testDAO.getAll().toString());
                                break;

                            case 0:
                                System.out.println("===========================================================");
                                break out;

                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 2:
                    Student student = (Student) ConsoleOperations.loginUser();
                    StudentService studentService = StudentService.getInstance();
                    studentMenu:
                    while (true) {
                        System.out.println("===========================================================");
                        System.out.println("1. Показать список тестов");
                        System.out.println("2. Пройти тест");

                        System.out.println("0. Назад");
                        System.out.println("===========================================================");

                        switch (ConsoleOperations.inputNumber()) {
                            case 1:
                                System.out.println("===========================================================");
                                System.out.println(testDAO.getAll().toString());
                                break;

                            case 2:
                                List<List<Integer>> questionAnswers = new ArrayList<>();
                                System.out.println("Введите название теста (одно слово без пробела)");
                                String testName = ConsoleOperations.inputString();
                                Test test = testDAO.getAll(SQLQueries.FIND_TEST_BY_NAME, testName).get(0);
                                if (test != null) {
                                    for (Question question : test.getQuestions()) {
                                        List<Integer> answer = new ArrayList<>();
                                        System.out.println(question);
                                        System.out.println("Введите Ваши вариант(ы) ответа (разделитель-пробел)");
                                        while (true) {
                                            try {
                                                answer = ConsoleOperations.inputArray();
                                            } catch (NumberFormatException e) {
                                                System.out.println("Неверный ввод! Повторите...");
                                                continue;
                                            }
                                            break;
                                        }
                                        questionAnswers.add(answer);
                                    }
                                    System.out.println("Результат: " + studentService.passingTest(student, test, questionAnswers));
                                } else {
                                    System.out.println("Тест с таким названием отсутствует!");
                                }
                                break;

                            case 0:
                                System.out.println("===========================================================");
                                break studentMenu;

                            default:
                                System.out.println("===========================================================");
                                System.out.println("Неверный выбор либо формат. Повторите...");
                        }
                    }
                    break;
                case 0:
                    System.out.println("===========================================================");
                    System.out.println("Работа завершена...");
                    System.out.println("===========================================================");
                    System.exit(0);

                default:
                    System.out.println("===========================================================");
                    System.out.println("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}