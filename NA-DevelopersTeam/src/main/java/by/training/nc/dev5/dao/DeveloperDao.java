package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.Project;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.entity.TimeSheet;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface DeveloperDao extends AbstractDao<Developer, Integer> {
    Collection<TimeSheet> getTimeSheets(Integer developerId);

    Collection<Developer> getUnassignedDevelopers(Integer qualificationId);
}
