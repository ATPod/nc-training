package by.training.nc.dev5.commands.student;

import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.commands.AbstractCommand;
import by.training.nc.dev5.constants.JspPaths;
import by.training.nc.dev5.services.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShowResultCommand extends AbstractCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Test test = (Test) session.getAttribute("test");
        List<Question> questions=test.getQuestions();
        Student student = (Student) session.getAttribute("user");
        List<List<Integer>> questionAnswers = new ArrayList<>();
        for (Question question:questions) {
            List<Integer> questionAnswer = new ArrayList<>();
            for (Option option:question.getAnswerOptions()) {
                String answerParameter = "answer" + option.getId();
                if (("1").equals(request.getParameter(answerParameter))) {
                    questionAnswer.add(option.getNumber());
                }
            }
            questionAnswers.add(questionAnswer);
        }
        StudentService studentService = StudentService.getInstance();
        int result = studentService.passingTest(student, test, questionAnswers);
        request.setAttribute("result", result);
        request.setAttribute("questionAnswers",questionAnswers);
        return JspPaths.SHOW_RESULT;
    }
}
