package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface ProjectDao extends AbstractDao<Project, Integer> {
    Collection<Developer> getDevelopers(Integer projectId);
}
