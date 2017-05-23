package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.dto.StudentDTO;
import by.training.nc.dev5.testing.entities.test.Option;
import by.training.nc.dev5.testing.entities.test.Question;
import by.training.nc.dev5.testing.entities.test.Test;
import by.training.nc.dev5.testing.entities.users.Student;
import by.training.nc.dev5.testing.entities.users.User;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IStudentService;
import by.training.nc.dev5.testing.utils.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;
    @RequestMapping(value = "/studentProfile", method = RequestMethod.GET)
    public String showStudentProfile(ModelMap model) {
        return "student_profile";
    }

    @RequestMapping(value = "/registerStudent", method = RequestMethod.GET)
    public String showStudentRegistrationForm(ModelMap model) {
        model.addAttribute("newStudent", new StudentDTO());
        return "student_form";
    }

    @RequestMapping(value = "/registerStudent", method = RequestMethod.POST)

    public String registerStudent(@ModelAttribute("newStudent") @Valid StudentDTO studentDTO, BindingResult bindingResult,
                                  ModelMap model) {
        if (!bindingResult.hasErrors()) {
            try {
                Student student = EntityBuilder.buildStudent(studentDTO.getFirstName(), studentDTO.getLastName(),
                        studentDTO.getLogin(), studentDTO.getPassword(), studentDTO.getScores());
                studentService.addEntity(student);
                return "login";
            } catch (ServiceException e) {
                model.addAttribute("errorMessage", "Database error");
                return "error";
            } catch (NullPointerException e) {
                model.addAttribute("errorMessage", "NullPointerException");
                return "error";
            }
        } else {
            return "student_form";
        }
    }

    @RequestMapping(value = "/showStudents", method = RequestMethod.GET)
    public String showStudents(ModelMap model) {
        try {
            model.addAttribute("students", studentService.getStudents());
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error");
            return "error";
        }
        return "students";
    }

    @RequestMapping(value = "/showTestResult", method = RequestMethod.GET)
    public String showCreateTestForm(WebRequest request, @ModelAttribute("test") Test test,
                                     @ModelAttribute("sessionUser") User user, ModelMap model) {
        try {
            List<Question> questions = test.getQuestions();
            Student student = (Student) user;
            List<List<Integer>> questionAnswers = new ArrayList<>();
            for (Question question : questions) {
                List<Integer> questionAnswer = new ArrayList<>();
                for (Option option : question.getAnswerOptions()) {
                    String answerParameter = "answer" + option.getId();
                    if (("1").equals(request.getParameter(answerParameter))) {
                        questionAnswer.add(option.getNumber());
                    }
                }
                questionAnswers.add(questionAnswer);
            }
            int result = studentService.passTest(student, test, questionAnswers);
            model.addAttribute("result", result);
            model.addAttribute("questionAnswers", questionAnswers);
            return "show_result";
        } catch (ServiceException e) {
            model.addAttribute("errorMessage", "Database error!");
            return "error";
        }
    }
}
