package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.exception.DataAccessException;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface ProjectDao extends AbstractDao<Project, Integer> {
    Project getProject(Integer termsOfReferenceId) throws DataAccessException;
}