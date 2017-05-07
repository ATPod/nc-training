package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.entity.TimeSheet;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface DeveloperDao extends AbstractDao<Developer, Integer> {
    /**
     * Gets all developers of particular qualification that are not assigned
     * to any project at the moment.
     * @param qualificationId qualification of developers to look up.
     * @return a collection of {@link Developer} objects
     */
    Collection<Developer> getUnassignedDevelopers(Integer qualificationId) throws DataAccessException;

    /**
     * Gets developers assigned to this project
     * @param projectId project id to get assigned developers
     * @return a collection of developers that are assigned to project
     * identified by {@code projectId}
     */
    Collection<Developer> getDevelopers(Integer projectId) throws DataAccessException;
}
