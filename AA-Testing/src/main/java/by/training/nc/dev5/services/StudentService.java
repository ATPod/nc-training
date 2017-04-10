package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Student;

import java.util.List;

//Singleton
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
        List<Question> questions = test.getQuestions();
        int questionAmount = questions.size();
        for (int i = 0; i < questionAmount; i++) {
            studentResult += answeringQuestion(student, questions.get(i), questionAnswers.get(i));
        }
        return studentResult;
    }

    private int answeringQuestion(Student student, Question question, List<Integer> answers) {
        for (Option option : question.getAnswerOptions()) {
            if (option.isRightness()) {
                //если пользователь пропустил правильный вариант
                if (!answers.contains(option.getNumber())) {
                    return 0;
                }
            } else {
                if (!option.isRightness()) {
                    //если выбрал неверный вариант
                    if (answers.contains(option.getNumber())) {
                        return 0;
                    }
                }

            }
        }
        student.setScores(student.getScores() + question.getScores());
        return 10;

    }
}
