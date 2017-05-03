package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface ProjectDao extends AbstractDao<Project, Integer> {
    Project getProject(Integer termsOfReferenceId) throws DataAccessException;

    Collection<Project> getProjects(int managerId)
            throws DataAccessException;
}
