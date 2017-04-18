package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.services.StudentService;
import by.training.nc.dev5.services.TutorService;
import by.training.nc.dev5.utils.Utils;

import java.util.*;

public class ConsoleOperations {
    private static Scanner input;

    static {
        input = new Scanner(System.in);
    }

    /**
     * Array input from console
     *
     * @return array of numbers
     */
    private static List<Integer> inputArray() {
        List<Integer> result=null;
        while (true) {
            try {
                result = new ArrayList<>();
                input = new Scanner(System.in);
                String stringArray = input.next();
                String[] stringNumbers = stringArray.split(" ");
                for (String number : stringNumbers) {
                    result.add(Integer.parseInt(number));
                }
            } catch (NumberFormatException e) {
               System.out.println("Неверный формат. Повторите ввод...");
                continue;
            }
            break;
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

    /**
     * Question object input from console
     *
     * @return new instance of Question object
     */
    public static Question inputQuestion() {
        int questionId = Utils.generateNumber(0, 100);
        List<Option> answerOptions = new ArrayList<>();
        System.out.println("Введите текст вопроса...");
        String text = inputString();
        System.out.println("Введите баллы за вопрос...");
        int scores = inputNumber();
        System.out.println("Количество вариантов ответа...");
        int optionNumber = inputNumber();
        for (int i = 0; i < optionNumber; i++) {
            int optionId = Utils.generateNumber(0, 100);
            System.out.println("Введите текст варианта ответа№ " + (i + 1));
            String optionText = inputString();
            Option option = new Option(optionId, questionId, optionText, i + 1, false);
            answerOptions.add(option);
        }
        System.out.println("Введите правильные варианты ответа (разделитель-пробел)...");
        List<Integer> integers = inputArray();
        for (Option option : answerOptions) {
            if (integers.contains(option.getNumber())) {
                option.setRightness(true);
            }
        }
        return new Question(questionId, 0, text, scores, answerOptions);
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
                    Tutor tutor = new Tutor();
                    int tutorId = Utils.generateNumber(0, 100);
                    tutor.setId(tutorId);
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
                                System.out.println(TestContainer.INSTANCE);
                                break;

                            case 2:
                                System.out.println("Введите название теста (одно слово без пробелов)");
                                String testName = ConsoleOperations.inputString();
                                System.out.println("Введите количество вопросов");
                                int questionAmount;
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
                                TestContainer.INSTANCE.addTest(test);
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
                    Student student = new Student();
                    int studentId = Utils.generateNumber(0, 100);
                    student.setId(studentId);
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
                                System.out.println(TestContainer.INSTANCE);
                                break;

                            case 2:
                                List<List<Integer>> questionAnswers = new ArrayList<>();
                                System.out.println("Введите название теста (одно слово без пробела)");
                                String testName = ConsoleOperations.inputString();
                                Test test = TestContainer.INSTANCE.getTest(testName);
                                if (test != null) {
                                    for (Question question : test.getQuestions()) {
                                        List<Integer> answer;
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
                    InitializationManager.saveTests("Tests");
                    System.exit(0);

                default:
                    System.out.println("===========================================================");
                    System.out.println("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}