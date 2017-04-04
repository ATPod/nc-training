package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.TimeSheet;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikita on 28.03.2017.
 */
public class TimeTrackingService {
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

    public void track(Developer developer, Date date, int timeSpent) {
        TimeSheetDao timeSheetDao = daoFactory.getTimeSheetDao();
        TimeSheet timeSheet = new TimeSheet();

        timeSheet.setTime(timeSpent);
        timeSheet.setDate(date);
        timeSheet.setProject(developer.getProject());
        timeSheet.setDeveloper(developer);

        timeSheetDao.create(timeSheet);
    }
}
