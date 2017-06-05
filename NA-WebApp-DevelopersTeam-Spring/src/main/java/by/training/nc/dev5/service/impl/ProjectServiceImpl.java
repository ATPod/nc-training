package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.TermsOfReferenceDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.*;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Manager;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.TermsOfReference;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;
    private final DeveloperDao developerDao;
    private final TermsOfReferenceDao termsOfReferenceDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao, DeveloperDao developerDao, TermsOfReferenceDao termsOfReferenceDao) {
        this.projectDao = projectDao;
        this.developerDao = developerDao;
        this.termsOfReferenceDao = termsOfReferenceDao;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<ProjectDto> getProjectsByManager(ManagerDto user) {
        Collection<Project> projects = projectDao.getProjects(user.getId());
        Collection<ProjectDto> projectDtos =
                new ArrayList<ProjectDto>(projects.size());

        for (Project project : projects) {
            ProjectDto dto = createProjectDto(project, user);

            projectDtos.add(dto);
        }

        return projectDtos;
    }

    private ProjectDto createProjectDto(Project project, ManagerDto user) {
        ProjectDto dto = new ProjectDto();
        Collection<Developer> developers = developerDao
                .getDevelopers(project.getId());
        Collection<DeveloperDto> developerDtos =
                new ArrayList<DeveloperDto>(developers.size());

        dto.setId(project.getId());
        dto.setManager(user);

        for (Developer developer : developers) {
            DeveloperDto developerDto = new DeveloperDto();
            QualificationDto qualificationDto = new QualificationDto();

            developerDto.setId(developer.getId());
            developerDto.setName(developer.getName());
            qualificationDto.setId(developer.getQualification().getId());
            qualificationDto.setName(developer.getQualification().getName());
            developerDto.setQualification(qualificationDto);

            developerDtos.add(developerDto);
        }

        dto.setDevelopers(developerDtos);

        return dto;
    }

    public void assignDevelopers(ProjectDto projectDto,
                                 Collection<DeveloperDto> developers) {
        for (DeveloperDto developerDto : developers) {
            Developer developer = developerDao
                    .getEntityById(developerDto.getId());
            Project project = projectDao.getEntityById(projectDto.getId());

            developer.setProject(project);
            developerDao.update(developer);
        }
    }

    @Override
    public void createProject(ProjectDto projectDto, TermsOfReferenceDto termsOfReferenceDto) {
        Project project = new Project();
        TermsOfReference terms = new TermsOfReference();
        Manager manager = new Manager();

        terms.setId(termsOfReferenceDto.getId());
        manager.setId(projectDto.getManager().getId());
        project.setTermsOfReference(terms);
        project.setManager(manager);

        projectDto.setId(projectDao.create(project));
    }
}
