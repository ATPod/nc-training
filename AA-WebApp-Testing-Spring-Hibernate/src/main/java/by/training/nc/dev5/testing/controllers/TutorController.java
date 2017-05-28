package by.training.nc.dev5.testing.controllers;

import by.training.nc.dev5.testing.dto.TutorDTO;
import by.training.nc.dev5.testing.entities.users.Tutor;
import by.training.nc.dev5.testing.services.exceptions.ServiceException;
import by.training.nc.dev5.testing.services.interfaces.IStudentService;
import by.training.nc.dev5.testing.services.interfaces.ITutorService;
import by.training.nc.dev5.testing.utils.EntityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
@Controller
public class TutorController {
    @Autowired
    ITutorService tutorService;
    @Autowired
    IStudentService studentService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/registerTutor", method = RequestMethod.GET)
    public String showTutorRegistrationForm(ModelMap model) {
        model.addAttribute("newTutor", new TutorDTO());
        return "tutor_form";
    }
    @RequestMapping(value = "/registerTutor", method = RequestMethod.POST)

    public String registerTutor(@ModelAttribute("newTutor") @Valid TutorDTO tutorDTO, BindingResult bindingResult,
                                ModelMap model) {
        if (!bindingResult.hasErrors()) {
            try {
                Tutor tutor = EntityBuilder.buildTutor(tutorDTO.getFirstName(), tutorDTO.getLastName(),
                        tutorDTO.getLogin(), tutorDTO.getPassword(), tutorDTO.getSubject());
                tutorService.addEntity(tutor);
                model.addAttribute("user", tutor);
                return "login";
            } catch (ServiceException e) {
                model.addAttribute("errorMessage", "Database error");
                return "error";
            } catch (NullPointerException e) {
                model.addAttribute("errorMessage", "NullPointerException");
                return "error";
            }
        } else {
            return "tutor_form";
        }
    }

}
