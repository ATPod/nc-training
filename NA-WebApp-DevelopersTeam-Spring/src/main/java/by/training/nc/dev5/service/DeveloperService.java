package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.QualificationDto;

import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public interface DeveloperService {
    Collection<DeveloperDto> getUnassignedDevelopers();

    Collection<DeveloperDto> getUnassignedDevelopers(QualificationDto qualification);
}
