package by.training.nc.dev5.commands.turor;

import by.training.nc.dev5.beans.users.*;
import by.training.nc.dev5.beans.test.*;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.services.TutorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddTestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        TutorService tutorService = TutorService.getInstance();
        HttpSession session = request.getSession();
        Tutor tutor = (Tutor) session.getAttribute("user");
        String testName = (String) session.getAttribute("testName");
        int questionAmount = (Integer) session.getAttribute("questionAmount");
        int optionAmount = (Integer) session.getAttribute("optionAmount");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < questionAmount; i++) {
            Question question = new Question();
            String questionText = request.getParameter("questionText" + (i + 1));
            int scores = Integer.parseInt(request.getParameter("questionBalls" + (i + 1)));
            question.setScores(scores);
            question.setText(questionText);
            List<Option> options = new ArrayList<>();
            for (int j = 0; j < optionAmount; j++) {
                Option option = new Option();
                String optionTextParam = "optionText" + (i + 1);
                String optionRightnessParam = "rightness" + (i + 1);
                optionTextParam += (j + 1);
                optionRightnessParam += (j + 1);
                String optionText = request.getParameter(optionTextParam);
                String rightness = request.getParameter(optionRightnessParam);
                int number = (j + 1);
                option.setNumber(number);
                option.setText(optionText);
                if (("1").equals(rightness)) {
                    option.setRightness(true);
                }
                options.add(option);
            }
            question.setAnswerOptions(options);
            questions.add(question);
        }
        Test test = tutorService.creatingTest(tutor, testName, questions);
        MySQLDAOFactory factory = new MySQLDAOFactory();
        InterfaceDAO<Test> testDAO = factory.getTestDAO();
        testDAO.insert(test);
        request.setAttribute("tests", testDAO.getAll());
        return JspPaths.TESTS;
    }
}
