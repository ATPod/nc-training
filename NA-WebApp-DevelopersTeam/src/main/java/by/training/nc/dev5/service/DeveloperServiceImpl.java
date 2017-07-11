package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.util.JpaUtil;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public class DeveloperServiceImpl implements DeveloperService {
    private static DaoFactory daoFactory;
    private DeveloperDao developerDao;

    static {
        daoFactory = new JpaDaoFactory(JpaUtil.getInstance());
    }

    {
        developerDao = daoFactory.getDeveloperDao();
    }

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
