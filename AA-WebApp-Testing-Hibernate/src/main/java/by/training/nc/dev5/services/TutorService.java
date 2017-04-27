package by.training.nc.dev5.services;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.dao.GenericDAO;
import java.util.List;


//Service for tutor
public class TutorService extends AbstractService<Tutor> {
    private static TutorService instance = null;
    private TutorService() {
        this.dao=new GenericDAO<>(Tutor.class);
    }

    public static TutorService getInstance() {
        if (instance == null) {
            instance = new TutorService();
        }
        return instance;
    }
    public Test creatingTest(Tutor tutor, String testName, List<Question> questions) {
        Test test = new Test();
        test.setQuestions(questions);
        test.setAuthor(tutor);
        test.setSubject(tutor.getSubject());
        test.setName(testName);
        test.setId(0);
        return test;
    }
}
