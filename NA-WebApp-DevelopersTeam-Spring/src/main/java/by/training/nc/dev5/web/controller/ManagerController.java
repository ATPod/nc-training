package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nikita on 04.06.2017.
 */
@Controller
@RequestMapping("/manager")
@SessionAttributes({"user"})
@Scope("session")
public class ManagerController {
    private final TermsOfReferenceService termsOfReferenceService;
    private final QualificationService qualificationService;
    private final DeveloperService developerService;
    private final ProjectService projectService;
    private final InvoiceService invoiceService;
    private final TimeSheetService timeSheetService;

    @Autowired
    public ManagerController(TermsOfReferenceService termsOfReferenceService,
                             QualificationService qualificationService,
                             DeveloperService developerService,
                             ProjectService projectService,
                             InvoiceService invoiceService,
                             TimeSheetService timeSheetService) {
        this.termsOfReferenceService = termsOfReferenceService;
        this.qualificationService = qualificationService;
        this.developerService = developerService;
        this.projectService = projectService;
        this.invoiceService = invoiceService;
        this.timeSheetService = timeSheetService;
    }

    @RequestMapping(value = "/pendingTerms", method = RequestMethod.GET)
    public ModelAndView pendingTerms() {
        ModelAndView modelAndView = new ModelAndView(
                "manager/show-pending-terms");
        Collection<TermsOfReferenceDto> pendingTerms = termsOfReferenceService
                .getPendingTerms();

        modelAndView.addObject("pendingTerms", pendingTerms);

        return modelAndView;
    }

    @ModelAttribute("qualifications")
    public void addQualifications(ModelMap modelMap) {
        modelMap.addAttribute("qualifications",
                qualificationService.getQualifications());
    }

    @ModelAttribute("projectsByManager")
    public void addProjectsByManager(
            ModelMap modelMap,
            @ModelAttribute("user") ManagerDto user) {

        modelMap.addAttribute("projectsByManager",
                projectService.getProjectsByManager(user));
    }

    @RequestMapping(value = "/assignDevelopers", method = RequestMethod.GET)
    public ModelAndView assignDevelopers(
            @RequestParam(required = false) Integer qualificationId) {
        ModelAndView modelAndView = new ModelAndView("manager/assign-developers");

        if (qualificationId != null) {
            Collection<DeveloperDto> unassignedDevelopers =
                    developerService.getUnassignedDevelopers(
                            qualificationService.getQualification(qualificationId));

            modelAndView.addObject("unassignedDevelopers", unassignedDevelopers);
        } else {
            modelAndView.addObject("unassignedDevelopers",
                    developerService.getUnassignedDevelopers());
        }

        return modelAndView;
    }

    @RequestMapping(value = "/assignDevelopers", method = RequestMethod.POST)
    public String assignDevelopers(
            @RequestParam int projectId,
            @RequestParam("developerId") Collection<Integer> developerIds) {

        Collection<DeveloperDto> developerDtos = new ArrayList<>();
        ProjectDto projectDto = new ProjectDto();

        for (int developerId : developerIds) {
            DeveloperDto developerDto = new DeveloperDto();

            developerDto.setId(developerId);
            developerDtos.add(developerDto);
        }

        projectDto.setId(projectId);
        projectService.assignDevelopers(projectDto, developerDtos);

        return "redirect:/manager/projects";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String projects(@ModelAttribute("user") ManagerDto user) {
        return "manager/show-my-projects";
    }

    @RequestMapping(value = "/issueInvoice", method = RequestMethod.GET)
    public String issueInvoice(@ModelAttribute("user") ManagerDto user) {
        return "manager/issue-invoice";
    }

    @RequestMapping(value = "/issueInvoice", method = RequestMethod.POST)
    public String issueInvoice(
            @RequestParam int projectId,
            @RequestParam double price) {
        ProjectDto projectDto = new ProjectDto();

        projectDto.setId(projectId);

        invoiceService.issueInvoice(projectDto, price);

        return "redirect:/home";
    }

    @RequestMapping(value = "/timeSheets", method = RequestMethod.GET)
    public ModelAndView timeSheets(
            @ModelAttribute("user") ManagerDto user,
            @ModelAttribute("projectsByManager") Collection<ProjectDto> projectsByManager,
            @RequestParam(required = false) Integer projectId) {
        ModelAndView modelAndView = new ModelAndView("manager/show-time-sheets");
        Collection<TimeSheetDto> timeSheets = new ArrayList<>();
        ProjectDto projectDto;

        List<ProjectDto> projectDtos = projectId == null
                ? new ArrayList<>()
                : projectsByManager.stream()
                    .filter(dto -> dto.getId() == projectId)
                    .collect(Collectors.toList());

        if (projectDtos.size() == 0) {
            return modelAndView;
        } else {
            projectDto = projectDtos.get(0);
        }

        for (DeveloperDto developerDto : projectDto.getDevelopers()) {
            timeSheets.addAll(timeSheetService.getTimeSheets(developerDto));
        }

        modelAndView.addObject("timeSheets", timeSheets);

        return modelAndView;
    }

    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public String createProject(
            @ModelAttribute("user") ManagerDto user,
            @RequestParam int termsId) {
        ProjectDto projectDto = new ProjectDto();
        TermsOfReferenceDto termsOfReferenceDto = new TermsOfReferenceDto();

        projectDto.setManager(user);
        termsOfReferenceDto.setId(termsId);
        projectService.createProject(projectDto, termsOfReferenceDto);

        return "redirect:/manager/projects";
    }
}
