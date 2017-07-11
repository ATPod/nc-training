package by.training.nc.dev5.web.rest;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by Nikita on 11.07.2017.
 */
@RestController
@RequestMapping("/rest/developers")
public class DevelopersResource {
    private DeveloperService developerService;

    @Autowired
    public DevelopersResource(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<DeveloperDto> getAllDevelopers(
            @RequestParam(required = false) Integer qualificationId) {

        if (qualificationId == null) {
            return developerService.getUnassignedDevelopers();
        } else {
            QualificationDto qualificationDto = new QualificationDto();

            qualificationDto.setId(qualificationId);

            return developerService.getUnassignedDevelopers(qualificationDto);
        }
    }
}
