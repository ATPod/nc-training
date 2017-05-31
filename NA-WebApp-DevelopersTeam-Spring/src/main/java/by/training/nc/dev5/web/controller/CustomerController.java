package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.service.QualificationService;
import by.training.nc.dev5.service.TermsOfReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    private TermsOfReferenceDto createdTerms;

    @Autowired
    public CustomerController(TermsOfReferenceService termsOfReferenceService,
                              QualificationService qualificationService) {
        this.termsOfReferenceService = termsOfReferenceService;
        this.qualificationService = qualificationService;

        createdTerms = new TermsOfReferenceDto();
        createdTerms.setTasks(new LinkedList<TaskDto>());
    }

    /**
     * Gets the value of createdTerms
     *
     * @return the value of createdTerms.
     */
    @ModelAttribute("createdTerms")
    public TermsOfReferenceDto getCreatedTerms() {
        return createdTerms;
    }

    /**
     * Sets the value of createdTerms
     *
     * @param createdTerms the new value of createdTerms.
     */
    public void setCreatedTerms(TermsOfReferenceDto createdTerms) {
        this.createdTerms = createdTerms;
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

        if (createdTerms == null) {
            createdTerms = new TermsOfReferenceDto();
        }

        if (createdTerms.getTasks() == null) {
            createdTerms.setTasks(new LinkedList<TaskDto>());
        }

        createdTerms.getTasks().add(taskDto);

        return "redirect:/customer/createTerms";
    }

    @RequestMapping(value = "/createTerms", method = RequestMethod.GET)
    public String createTermsGet(ModelMap modelMap) {
        if (!modelMap.containsAttribute("createdTerms")) {
            TermsOfReferenceDto createdTerms = new TermsOfReferenceDto();

            createdTerms.setTasks(new LinkedList<TaskDto>());
            modelMap.addAttribute("createdTerms", createdTerms);
        }

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
        // A little hack to reset value of createdTerms because
        // ModelMap#remove() does not work properly.
        TermsOfReferenceDto createdTerms = new TermsOfReferenceDto();

        createdTerms.setTasks(new LinkedList<TaskDto>());
        modelMap.addAttribute("createdTerms", createdTerms);

        return "redirect:/customer/createTerms";
    }
}
