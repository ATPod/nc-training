package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.exceptions.StudentLogicException;
import by.training.nc.dev5.tools.ConsoleOperations;

import java.util.Collections;
import java.util.List;

/**
 * Created by NotePad.by on 16.03.2017.
 */
public class StudentService {
    private static StudentService instance = null;

    private StudentService() {
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public int passingTest(Student student, Test test,
                           List<List<Integer>> questionAnswers) {
        int studentResult = 0;
        int questionAmount = test.getQuestions().size();
        List<Question> testQuestions = test.getQuestions();
        for (int i = 0; i < questionAmount; i++) {
            studentResult += answeringQuestion(student, testQuestions.get(i),
                    questionAnswers.get(i));
        }
        return studentResult;
    }

    private int answeringQuestion(Student student, Question question,
                                  List<Integer> answers) {
        Collections.sort(answers);
        if (answers.equals(question.getRightAnswersNumbers())) {
            try {
                student.setBalls(student.getBalls() + question.getBalls());
                return question.getBalls();
            } catch (StudentLogicException e) {
                System.out.println(e.getMessage());
            }
        }
        return 0;
    }
}
