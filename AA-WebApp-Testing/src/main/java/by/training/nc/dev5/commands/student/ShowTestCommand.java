package by.training.nc.dev5.commands.student;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.dao.factory.MySQLDAOFactory;
import by.training.nc.dev5.dao.interfaces.InterfaceDAO;
import by.training.nc.dev5.sql.SQLQueries;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowTestCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        int testId=Integer.parseInt(request.getParameter("testId"));
        MySQLDAOFactory factory=new MySQLDAOFactory();
        InterfaceDAO<Test> testDAO=factory.getTestDAO();
        InterfaceDAO<Question> questionDAO=factory.getQuestionDAO();
        InterfaceDAO<Option> optionDAO=factory.getOptionDAO();
        Test test=testDAO.find(testId);
        List<Question> questions=questionDAO.getAll(SQLQueries.FIND_TEST_QUESTIONS,testId);
        for(Question question:questions)
        {
            List<Option> options=optionDAO.getAll(SQLQueries.FIND_QUESTION_OPTIONS,question.getId());
            question.setAnswerOptions(options);
        }
        test.setQuestions(questions);
        HttpSession session=request.getSession();
        session.setAttribute("test",test);
        return JspPaths.TEST_TO_PASS;
    }
}
