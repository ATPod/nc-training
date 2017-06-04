package by.training.nc.dev5.web.controller;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.TimeSheetDto;
import by.training.nc.dev5.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by Nikita on 31.05.2017.
 */
@Controller
@RequestMapping("/developer")
@Scope("session")
@SessionAttributes({"user"})
public class DeveloperController {
    private final TimeSheetService timeSheetService;

    @Autowired
    public DeveloperController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @RequestMapping(value = "/timeSheets", method = RequestMethod.GET)
    public ModelAndView goTrack(
            @ModelAttribute("user") DeveloperDto user) {

        ModelAndView modelAndView = new ModelAndView();
        Collection<TimeSheetDto> timeSheets = timeSheetService.getTimeSheets(user);

        modelAndView.addObject("timeSheets", timeSheets);
        modelAndView.setViewName("/developer/track");

        return modelAndView;
    }

    @RequestMapping(value = "trackTime", method = RequestMethod.POST)
    public ModelAndView trackTime(
            @ModelAttribute("user") DeveloperDto user,
            @RequestParam int time) {
        ModelAndView modelAndView = new ModelAndView();

        if (user.getProject() == null) {
            // TODO: localize
            modelAndView.addObject(
                    "trackTimeErrorMessage",
                    "You are not assigned to any project");
            modelAndView.setViewName("/developer/track");

            return modelAndView;
        }

        timeSheetService.trackTime(user, time);

        modelAndView.setViewName("redirect:/developer/timeSheets");

        return modelAndView;
    }
}
