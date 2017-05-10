package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.TimeSheet;

import java.util.Date;

/**
 * Created by Nikita on 10.05.2017.
 */
public class TimeTrackingServiceImpl implements TimeTrackingService {
    private static DaoFactory daoFactory;
    private TimeSheetDao timeSheetDao;
    private DeveloperDao developerDao;
    private ProjectDao projectDao;

    static {
        daoFactory = new JpaDaoFactory();
    }

    {
        projectDao = daoFactory.getProjectDao();
        timeSheetDao = daoFactory.getTimeSheetDao();
        developerDao = daoFactory.getDeveloperDao();
    }

    public void trackTime(DeveloperDto user, int timeSpent) {
        Developer developer = developerDao.getEntityById(user.getId());
        TimeSheet timeSheet = new TimeSheet();



        timeSheet.setTime(timeSpent);
        timeSheet.setDate(new Date());
        timeSheet.setDeveloper(developer);
        timeSheet.setProject(developer.getProject());
    }
}
