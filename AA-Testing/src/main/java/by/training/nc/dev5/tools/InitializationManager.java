package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.serialization.TestContainerSerializer;
import by.training.nc.dev5.services.StudentService;
import by.training.nc.dev5.services.TutorService;

import java.io.*;
import java.util.*;

public class InitializationManager {
    private static TestContainer tests = new TestContainer();

    public static String getTextFilePath(String fileName) {
        StringBuilder path = new StringBuilder();
        path.append(System.getProperty("user.dir"))
                .append(File.separator)
                .append("AA-Testing")
                .append(File.separator)
                .append("src")
                .append(File.separator)
                .append("main")
                .append(File.separator)
                .append("java")
                .append(File.separator)
                .append("by")
                .append(File.separator)
                .append("training")
                .append(File.separator)
                .append("nc")
                .append(File.separator)
                .append("dev5")
                .append(File.separator)
                .append("files")
                .append(File.separator)
                .append("input")
                .append(File.separator)
                .append(fileName);
        return path.toString();
    }

    public static void readFromFile(String fileName) {
        tests = new TestContainer();
        String path = getTextFilePath(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл для чтения!");
        }
        while (scan.hasNext()) {
            List<Question> questions = new ArrayList<>();
            Map<Integer, String> variants = new HashMap<>();
            List<Integer> rightAnswersNumbers = new ArrayList<>();
            scan.findWithinHorizon("Имя автора: ", 0);
            String authorName = scan.next();
            scan.findWithinHorizon("Фамилия автора: ", 0);
            String authorSurname = scan.next();
            scan.findWithinHorizon("Предмет: ", 0);
            String subject = scan.next();
            scan.findWithinHorizon("Название теста: ", 0);
            String testName = scan.next();
            scan.findWithinHorizon("Количество вопросов: ", 0);
            int questionAmount = scan.nextInt();
            for (int i = 0; i < questionAmount; i++) {
                scan.findWithinHorizon("Текст вопроса: ", 0);
                String text = scan.next();
                scan.findWithinHorizon("Баллы за вопрос: ", 0);
                int balls = scan.nextInt();
                scan.findWithinHorizon("Количество вариантов ответа в вопросе: ", 0);
                int variantAmount = scan.nextInt();
                for (int j = 0; j < variantAmount; j++) {
                    int variantNumber = scan.nextInt();
                    String variantText = scan.next();
                    variants.put(variantNumber, variantText);
                }
                scan.findWithinHorizon("Правильные варианты ответа: ", 0);
                while (scan.hasNextInt()) {
                    rightAnswersNumbers.add(scan.nextInt());
                }
                questions.add(new Question(text, balls, variants, rightAnswersNumbers));
            }
            Test test = new Test(authorName, authorSurname, subject,
                    testName, questions);
            tests.addTest(test);
        }

    }

    public static void saveToFile(String fileName) {
        String path = getTextFilePath(fileName);
        try (PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))))) {
            for (Test test : tests.getTests()) {
                printer.println("Имя автора: " + test.getAuthorName());
                printer.println("Фамилия автора: " + test.getAuthorSurname());
                printer.println("Предмет: " + test.getSubject());
                int questionAmount = test.getQuestions().size();
                printer.println("Количество вопросов: " + questionAmount);
                for (Question question : test.getQuestions()) {
                    printer.println("Текст вопроса: " + question.getText());
                    printer.println("Баллы за вопрос: " + question.getBalls());
                    printer.println("Количество вариантов ответа в вопросе: "
                            + question.getVariants().size());
                    for (Map.Entry<Integer, String> entry : question.getVariants().entrySet()) {
                        printer.println(entry.getKey() + " " + entry.getValue());
                    }
                    printer.print("Правильные варианты ответа: ");
                    for (Integer number : question.getRightAnswersNumbers()) {
                        printer.print(number + " ");
                    }
                    printer.println();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void menu() {
        while (true) {
            System.out.println("===========================================================");
            System.out.println("Выберите пользователя:");
            System.out.println("1. Tutor");
            System.out.println("2. Student");
            System.out.println("0. Выход");
            System.out.println("===========================================================");


            switch (ConsoleOperations.inputNumber()) {
                case 1:
                    Tutor tutor = ConsoleOperations.inputTutor();
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
                                System.out.println(tests.toString());
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
                                tests.addTest(tutorService.creatingTest(tutor, testName, questionAmount));
                                System.out.println(tests.toString());
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
                    Student student = ConsoleOperations.inputStudent();
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
                                System.out.println(tests.toString());
                                break;

                            case 2:
                                List<List<Integer>> questionAnswers = new ArrayList<>();
                                System.out.println("Введите название теста (одно слово без пробела)");
                                String testName = ConsoleOperations.inputString();
                                Test test = tests.getTest(testName);
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
                    saveToFile("Tests");
                    TestContainerSerializer serializer=new TestContainerSerializer();
                    serializer.serialization(tests,getTextFilePath("Serialized.dat"));
                    System.out.println("===========================================================");
                    System.exit(0);

                default:
                    System.out.println("===========================================================");
                    System.out.println("Неверный выбор либо формат. Повторите...");
            }
        }
    }
}