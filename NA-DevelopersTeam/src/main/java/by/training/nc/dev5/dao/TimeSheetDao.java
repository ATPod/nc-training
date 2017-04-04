package by.training.nc.dev5.dao;

import by.training.nc.dev5.entity.TimeSheet;

import java.util.Collection;

/**
 * Created by Nikita on 26.03.2017.
 */
public interface TimeSheetDao extends AbstractDao<TimeSheet, Integer> {
    /**
     * Gets all time sheets associated with specified developer.
     * @param developerId   an id of developer to see time sheets of
     * @return a collection of {@link TimeSheet} objects
     */
    Collection<TimeSheet> getTimeSheets(Integer developerId);
}
