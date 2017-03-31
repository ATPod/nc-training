package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Student;

import java.util.List;


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

    private int answeringQuestion(Student student, Question question, List<Integer> answers) {
        return 0;
    }
}
