package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.tools.ConsoleOperations;

import java.util.ArrayList;
import java.util.List;

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
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < questionAmount; i++) {
            questions.add(ConsoleOperations.inputQuestion());
        }
        return null;
    }
}
