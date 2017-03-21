package by.training.nc.dev5.dao;

import by.training.nc.dev5.model.Developer;

import java.util.List;

/**
 * Created by Nikita on 21.03.2017.
 */
public interface DeveloperDao extends AbstractDao<Developer, Integer> {
    List<Developer> getUnassignedDevelopers();
}
