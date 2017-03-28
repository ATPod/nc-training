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
    private static final int DAY_MILLIS = 24 * 60 * 60 * 1000;
    private final DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    private Map<Developer, Date> developerStartTimeMap;

    public TimeTrackingService() {
        developerStartTimeMap = new HashMap<Developer, Date>();
    }

    public void startTracking(Developer developer, Date start) {
        developerStartTimeMap.put(developer, start);
    }
    
    public void stopTracking(Developer developer, Date stop) {
        TimeSheetDao timeSheetDao = daoFactory.getTimeSheetDao();
        TimeSheet timeSheet = new TimeSheet();
        Date start = developerStartTimeMap.get(developer);
        int time = (int) (stop.getTime() - start.getTime());

        if (time > DAY_MILLIS || time < 0) {
            throw new RuntimeException("Not valid stop date");
            // TODO: handle this properly
        }
        
        timeSheet.setProjectId(developer.getProjectId());
        timeSheet.setDeveloperId(developer.getId());
        timeSheet.setDate(stop);
        timeSheet.setTime(time);

        timeSheetDao.create(timeSheet);
    }
}
