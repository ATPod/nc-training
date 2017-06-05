package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ManagerDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.dto.TermsOfReferenceDto;

import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public interface ProjectService {
    Collection<ProjectDto> getProjectsByManager(ManagerDto user);

    void assignDevelopers(ProjectDto project, Collection<DeveloperDto> developers);

    void createProject(ProjectDto projectDto, TermsOfReferenceDto termsOfReferenceDto);
}
