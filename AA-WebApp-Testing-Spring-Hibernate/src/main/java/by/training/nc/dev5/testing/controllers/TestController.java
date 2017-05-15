package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.dto.TestDTO;
import by.training.nc.dev5.testing.entities.test.Option;
import by.training.nc.dev5.testing.entities.test.Question;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.entities.users.Tutor;
import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    ITestService testService;

    @RequestMapping(value = "/createTest", method = RequestMethod.GET)
    public String showCreateTestForm(ModelMap model) {
        model.addAttribute("testParameters", new TestDTO());
        return "create_test_form";
    }

    @RequestMapping(value = "/showTest", method = RequestMethod.GET)
    public String showTest(@RequestParam("testId") int testId, ModelMap model) {
        try {
            Test test = testService.findById(testId);
            model.addAttribute("test", test);
            return "test";
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error!");
            return "error";
        }

    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public String createTest(@ModelAttribute("testParameters") TestDTO testDTO, @ModelAttribute ModelMap model) {
        Test test = new Test();
        test.setName(testDTO.getTestName());
        test.setQuestions(new ArrayList<Question>(testDTO.getQuestionAmount()));
        for (Question question : test.getQuestions()) {
            question.setAnswerOptions(new ArrayList<Option>(testDTO.getOptionAmount()));
        }
        model.addAttribute("test", test);
        return "fill_test_form";
    }

    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public String addTest(WebRequest request, @ModelAttribute("test") Test test, @ModelAttribute("sessionUser") User user,
                          ModelMap model) {
        try {
            int questionAmount = test.getQuestions().size();
            int optionAmount = test.getQuestions().get(0).getAnswerOptions().size();
            test.setAuthor((Tutor) user);
            for (int i = 0; i < questionAmount; i++) {
                Question question = test.getQuestions().get(i);
                String questionText = request.getParameter("questionText" + (i + 1));
                int scores = Integer.parseInt(request.getParameter("questionBalls" + (i + 1)));
                question.setScores(scores);
                question.setText(questionText);
                List<Option> options = question.getAnswerOptions();
                for (int j = 0; j < optionAmount; j++) {
                    Option option = options.get(i);
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
                        option.setRight(true);
                    }
                }
            }
            testService.addEntity(test);
            return "all_tests";
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error!");
            return "error";
        }


    }

    @RequestMapping(value = "/allTests", method = RequestMethod.GET)
    public String showAllTests(ModelMap model) {
        try {
            List<Test> tests = testService.getAll();
            model.addAttribute("tests", tests);
            return "all_tests";
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error!");
            return "error";
        }

    }

}
