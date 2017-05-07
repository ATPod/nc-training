package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.TimeSheet;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Date;

/**
 * Created by Nikita on 28.03.2017.
 */
public class TimeTrackingService {
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory();

    public void track(Developer developer, Date date, int timeSpent) {
        TimeSheetDao timeSheetDao = daoFactory.getTimeSheetDao();
        TimeSheet timeSheet = new TimeSheet();

        timeSheet.setTime(timeSpent);
        timeSheet.setDate(date);
        timeSheet.setProject(developer.getProject());
        timeSheet.setDeveloper(developer);

        try {
            timeSheetDao.create(timeSheet);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
