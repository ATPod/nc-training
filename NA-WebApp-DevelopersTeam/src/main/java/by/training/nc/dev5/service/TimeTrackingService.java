package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.DeveloperDto;

/**
 * Created by Nikita on 10.05.2017.
 */
public interface TimeTrackingService {
    void trackTime(DeveloperDto user, int timeSpent);
}
