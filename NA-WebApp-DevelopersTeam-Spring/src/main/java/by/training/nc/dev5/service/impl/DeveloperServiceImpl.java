package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DataAccessException.class)
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    private DeveloperDao developerDao;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<DeveloperDto> getUnassignedDevelopers() {
        Collection<Developer> unassignedDevelopers =
                developerDao.getUnassignedDevelopers();
        Collection<DeveloperDto> result =
                new ArrayList<DeveloperDto>(unassignedDevelopers.size());

        for (Developer developer : unassignedDevelopers) {
            result.add(createDeveloperDto(developer));
        }

        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<DeveloperDto> getUnassignedDevelopers(
            QualificationDto qualification) {

        Collection<Developer> unassignedDevelopers = developerDao
                .getUnassignedDevelopers(qualification.getId());
        Collection<DeveloperDto> unassignedDeveloperDtos =
                new ArrayList<DeveloperDto>(unassignedDevelopers.size());

        for (Developer developer : unassignedDevelopers) {
            unassignedDeveloperDtos.add(createDeveloperDto(developer));
        }

        return unassignedDeveloperDtos;
    }

    private DeveloperDto createDeveloperDto(Developer developer) {
        DeveloperDto dto = new DeveloperDto();
        QualificationDto qualificationDto = new QualificationDto();

        dto.setId(developer.getId());
        dto.setName(developer.getName());

        qualificationDto.setId(developer.getQualification().getId());
        qualificationDto.setName(developer.getQualification().getName());

        dto.setQualification(qualificationDto);

        return dto;
    }
}
