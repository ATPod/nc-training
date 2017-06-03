package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.DeveloperDto;
import by.training.nc.dev5.dto.TimeSheetDto;

import java.util.Collection;

/**
 * Created by Nikita on 10.05.2017.
 */
public interface TimeSheetService {
    void trackTime(DeveloperDto user, int timeSpent);

    Collection<TimeSheetDto> getTimeSheets(DeveloperDto developer);
}
