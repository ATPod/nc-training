package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.TermsOfReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
            @RequestParam("specification") String specification,
            @RequestParam("qualificationId") int qualificationId,
            @RequestParam("developersNumber") int developersNumber) {

        QualificationDto qualificationDto = qualificationService
                .getQualification(qualificationId);
        TaskDto taskDto = new TaskDto();

        taskDto.setQuotas(new HashMap<QualificationDto, Integer>());
        taskDto.getQuotas().put(qualificationDto, developersNumber);
        taskDto.setSpecification(specification);

        if (createdTerms.getTasks() == null) {
            createdTerms.setTasks(new LinkedList<TaskDto>());
        }

        createdTerms.getTasks().add(taskDto);

        return "redirect:/customer/createTerms";
    }

    @RequestMapping(value = "/createTerms", method = RequestMethod.GET)
    public String createTermsGet() {
        return "customer/create-terms";
    }

    @RequestMapping(value = "/createTerms", method = RequestMethod.POST)
    public String createTermsPost(
            @ModelAttribute("createdTerms") TermsOfReferenceDto createdTerms) {

        termsOfReferenceService.applyTermsOfReference(createdTerms);

        return "redirect:/customer/terms";
    }

    @RequestMapping(value = "/cancelTerms", method = RequestMethod.POST)
    public String cancelTermsPost(ModelMap modelMap) {
        modelMap.remove("createdTerms");

        return "redirect:/customer/createTerms";
    }
}
