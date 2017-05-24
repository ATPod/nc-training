package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.dao.DeveloperDao;
import by.training.nc.dev5.dao.ProjectDao;
import by.training.nc.dev5.dao.TimeSheetDao;
import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.ProjectDto;
import by.training.nc.dev5.dto.TimeSheetDto;
import by.training.nc.dev5.entity.Developer;
import by.training.nc.dev5.entity.TimeSheet;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Nikita on 10.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DataAccessException.class)
public class TimeSheetServiceImpl implements TimeSheetService {
    @Autowired
    private TimeSheetDao timeSheetDao;
    @Autowired
    private DeveloperDao developerDao;
    @Autowired
    private ProjectDao projectDao;

    public void trackTime(DeveloperDto user, int timeSpent) {
        Developer developer = developerDao.getEntityById(user.getId());
        TimeSheet timeSheet = new TimeSheet();

        timeSheet.setTime(timeSpent);
        timeSheet.setDate(new Date());
        timeSheet.setDeveloper(developer);
        timeSheet.setProject(
                projectDao.getProjectByDeveloper(developer.getId()));

        timeSheetDao.create(timeSheet);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<TimeSheetDto> getTimeSheets(DeveloperDto developer) {
        Collection<TimeSheet> timeSheets = timeSheetDao
                .getTimeSheets(developer.getId());
        Collection<TimeSheetDto> result =
                new ArrayList<TimeSheetDto>(timeSheets.size());

        for (TimeSheet timeSheet : timeSheets) {
            result.add(createTimeSheetDto(timeSheet));
        }

        return result;
    }

    private TimeSheetDto createTimeSheetDto(TimeSheet timeSheet) {
        TimeSheetDto dto = new TimeSheetDto();
        ProjectDto projectDto = new ProjectDto();
        DeveloperDto developerDto = new DeveloperDto();

        dto.setId(timeSheet.getId());
        dto.setTime(timeSheet.getTime());
        dto.setDate(timeSheet.getDate());

        projectDto.setId(timeSheet.getProject().getId());
        dto.setProject(projectDto);

        developerDto.setName(timeSheet.getDeveloper().getName());
        developerDto.setId(timeSheet.getDeveloper().getId());
        dto.setDeveloper(developerDto);

        return dto;
    }
}
