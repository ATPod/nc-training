package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.TermsOfReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Nikita on 24.05.2017.
 */
@Controller
@RequestMapping("/customer")
@SessionAttributes({"user", "createdTerms"})
@Scope("session")
public class CustomerController extends MultiActionController {
    private final TermsOfReferenceService termsOfReferenceService;
    private final QualificationService qualificationService;

    @Autowired
    public CustomerController(TermsOfReferenceService termsOfReferenceService,
                              QualificationService qualificationService) {
        this.termsOfReferenceService = termsOfReferenceService;
        this.qualificationService = qualificationService;
    }

    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public ModelAndView showTermsOfReference(
            @ModelAttribute("user") PersonDto user) {
        ModelAndView modelAndView = new ModelAndView();
        CustomerDto customer = (CustomerDto) user;
        Collection<TermsOfReferenceDto> terms =
                termsOfReferenceService.getTermsByCustomer(customer);

        modelAndView.setViewName("customer/show-my-terms");
        modelAndView.addObject("terms", terms);

        return modelAndView;
    }

    @RequestMapping(
            value = "/addTask",
            method = RequestMethod.POST,
            params = {"specification", "qualificationId", "developersNumber"})
    public String addTask(
            @ModelAttribute("createdTerms") TermsOfReferenceDto createdTerms,
            @ModelAttribute("user") CustomerDto user,
            @RequestParam("qualificationId") int qualificationId,
            @RequestParam("specification") String specification,
            @RequestParam("developersNumber") int developersNumber) {

        TaskDto taskDto = new TaskDto();
        QualificationDto qualification = qualificationService
                .getQualification(qualificationId);

        taskDto.setQuotas(new HashMap<QualificationDto, Integer>());
        taskDto.getQuotas().put(qualification, developersNumber);
        taskDto.setSpecification(specification);

        createdTerms.getTasks().add(taskDto);

        return "redirect:/customer/createTerms";
    }

    @RequestMapping(value = "/createTerms", method = RequestMethod.GET)
    public ModelAndView createTermsGet(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("customer/create-terms");

        if (!modelMap.containsAttribute("createdTerms")) {
            addCreatedTerms(modelMap);
        }

        modelAndView.addObject("qualification", new QualificationDto());

        return modelAndView;
    }

    @RequestMapping(value = "/createTerms", method = RequestMethod.POST)
    public String createTermsPost(
            @ModelAttribute("createdTerms") TermsOfReferenceDto createdTerms,
            ModelMap modelMap) {
        termsOfReferenceService.applyTermsOfReference(createdTerms);

        // A little hack to reset value of createdTerms because
        // ModelMap#remove() does not work properly.
        addCreatedTerms(modelMap);

        return "redirect:/customer/terms";
    }

    @RequestMapping(value = "/cancelTerms", method = RequestMethod.POST)
    public String cancelTermsPost(
            ModelMap modelMap) {
        // A little hack to reset value of createdTerms because
        // ModelMap#remove() does not work properly.
        addCreatedTerms(modelMap);

        return "redirect:/customer/createTerms";
    }

    @ModelAttribute("createdTerms")
    private void addCreatedTerms(ModelMap modelMap) {
        TermsOfReferenceDto createdTerms = new TermsOfReferenceDto();
        CustomerDto user = (CustomerDto) modelMap.get("user");

        createdTerms.setTasks(new LinkedList<TaskDto>());
        createdTerms.setCustomer(user);
        modelMap.addAttribute("createdTerms", createdTerms);
    }

    @ModelAttribute("qualifications")
    public void addQualifications(ModelMap modelMap) {
        Collection<QualificationDto> qualifications = qualificationService
                .getQualifications();

        modelMap.addAttribute("qualifications", qualifications);
    }
}
