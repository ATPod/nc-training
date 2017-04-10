package by.training.nc.dev5.tools;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.test.TestContainer;
import by.training.nc.dev5.logger.TestingSystemLogger;
import by.training.nc.dev5.utils.Utils;

import static by.training.nc.dev5.constants.FileStrings.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Initializing options
 *
 * @author Alena Artsiuschcyk
 * @version 1.0
 */

public class InitializationManager {
    /**
     * @param fileName name of file
     * @return path of file with fileName name
     */
    private static String getTextFilePath(String fileName) {
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

    /**
     * @param fileName file to write
     */

    public static void saveToFile(String fileName) {

    }

    private static List<Test> readFromFile(String fileName) {
        List<Test> tests=new ArrayList<>();
        String filepath = getTextFilePath(fileName);
        try (Scanner scan = new Scanner(new File(filepath))) {
            while (scan.hasNext()) {
                scan.findWithinHorizon(TEST_ID, 0);
                int id = scan.nextInt();
                scan.findWithinHorizon(TEST_NAME, 0);
                String testName = scan.next();
                scan.findWithinHorizon(TEST_SUBJECT, 0);
                String testSubject = scan.next();
                scan.findWithinHorizon(TEST_QUESTION_AMOUNT, 0);
                int questionAmount = scan.nextInt();
                List<Question> questions = new ArrayList<>();
                for (int i = 0; i < questionAmount; i++) {
                    int questionId = Utils.generateNumber(0, 100);
                    scan.findWithinHorizon(QUESTION_TEXT, 0);
                    String questionText = scan.nextLine();
                    scan.findWithinHorizon(QUESTION_SCORES, 0);
                    int scores = scan.nextInt();
                    scan.findWithinHorizon(OPTION_AMOUNT, 0);
                    int optionAmount = scan.nextInt();
                    List<Option> options = new ArrayList<>();
                    for (int j = 0; j < optionAmount; j++) {
                        Option option = new Option();
                        int optionNumber = scan.nextInt();
                        String optionText = scan.next();
                        option.setText(optionText);
                        option.setNumber(optionNumber);
                        option.setQuestionId(questionId);
                        option.setId(Utils.generateNumber(0, 100));
                        options.add(option);
                    }
                    scan.findWithinHorizon(QUESTION_RIGHT_ANSWERS, 0);
                    List<Integer> rightAnswers = new ArrayList<>();
                    while (scan.hasNextInt()) {
                        rightAnswers.add(scan.nextInt());
                    }
                    for (Option option : options) {
                        if (rightAnswers.contains(option.getNumber())) {
                            option.setRightness(true);
                        }
                    }
                    Question question = new Question(questionId, id, questionText, scores, options);
                    questions.add(question);
                }
                Test test=new Test(id, 0, testSubject, testName, questions);
                tests.add(test);
            }

        } catch (FileNotFoundException e) {
            TestingSystemLogger.INSTANCE.logError(InitializationManager.class, e.getMessage());
        }
      return tests;
    }
    public static void fillTests(String fileName)
    {
        List<Test> tests=readFromFile(fileName);
        TestContainer.INSTANCE.setTests(tests);
    }
    public static void saveTests(String fileName)
    {
        List<Test> tests=TestContainer.INSTANCE.getTests();
        saveToFile(fileName);
    }
}
