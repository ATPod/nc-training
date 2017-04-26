package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.tools.ConsoleOperations;
import by.training.nc.dev5.utils.Utils;

import java.util.ArrayList;
import java.util.List;
//Singleton
public class TutorService {
    private static TutorService instance = null;

    private TutorService() {
    }

    public static TutorService getInstance() {
        if (instance == null) {
            instance = new TutorService();
        }
        return instance;
    }

    public Test creatingTest(Tutor tutor, String testName, int questionAmount) {
        int testId = Utils.generateNumber(0, 100);
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < questionAmount; i++) {
            Question question = ConsoleOperations.inputQuestion();
            question.setTestId(testId);
            questions.add(question);
        }
        return new Test(testId, tutor.getId(), tutor.getSubject(), testName, questions);
    }
}
