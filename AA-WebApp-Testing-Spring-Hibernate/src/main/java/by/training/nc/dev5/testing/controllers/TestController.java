package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.dto.TestDTO;
import by.training.nc.dev5.testing.entities.test.Option;
import by.training.nc.dev5.testing.entities.test.Question;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.entities.users.Tutor;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"optionAmount", "questionAmount", "testName"})
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
    public String createTest(@ModelAttribute("testParameters") TestDTO testDTO, ModelMap model) {
        model.addAttribute("optionAmount", testDTO.getOptionAmount());
        model.addAttribute("questionAmount", testDTO.getQuestionAmount());
        model.addAttribute("testName", testDTO.getTestName());
        return "redirect:/" + "fillTest";
    }
    @RequestMapping(value = "/fillTest", method = RequestMethod.GET)
    public String fillTest(@ModelAttribute("optionAmount") int optionAmount,
                           @ModelAttribute("questionAmount") int questionAmount,
                           @ModelAttribute("testName") String testName,Model model) {
        model.addAttribute("optionAmount",optionAmount);
        model.addAttribute("questionAmount",questionAmount);
        model.addAttribute("testName",testName);
       return "fill_test_form";
    }

    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public String addTest(HttpServletRequest request, @ModelAttribute("optionAmount") int optionAmount,
                          @ModelAttribute("questionAmount") int questionAmount,
                          @ModelAttribute("testName") String testName,
                          ModelMap model) {
        try {
            Test test = new Test();
            test.setName(testName);
            Tutor tutor = (Tutor) request.getSession().getAttribute("sessionUser");
            test.setAuthor(tutor);
            List<Question> questions=new ArrayList<>();
            for (int i = 0; i < questionAmount; i++) {
                Question question = new Question();
                String questionText = request.getParameter("questionText" + (i + 1));
                int scores = Integer.parseInt(request.getParameter("questionBalls" + (i + 1)));
                question.setScores(scores);
                question.setText(questionText);
                questions.add(question);
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
                        option.setRight(true);
                    }
                    options.add(option);
                }
                question.setAnswerOptions(options);
            }
            test.setQuestions(questions);
            testService.addEntity(test);
            model.addAttribute("testName", testName);
            return "redirect:/" + "allTests";
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
