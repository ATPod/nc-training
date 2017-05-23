package by.training.nc.dev5.testing.services;

import by.training.nc.dev5.testing.dao.interfaces.ITutorDAO;
import by.training.nc.dev5.testing.entities.users.Tutor;
import by.training.nc.dev5.testing.services.interfaces.ITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TutorService extends AbstractService<Tutor> implements ITutorService {
    @Autowired
    ITutorDAO tutorDAO;
    public TutorService(ITutorDAO tutorDAO){
        super(tutorDAO);
        this.tutorDAO = tutorDAO;
    }
   /* @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Test creatingTest(Tutor tutor, String testName, List<Question> questions) {
        Test test = new Test();
        test.setQuestions(questions);
        test.setAuthor(tutor);
        test.setSubject(tutor.getSubject());
        test.setName(testName);
        test.setId(0);
        return test;
    }*/
}
