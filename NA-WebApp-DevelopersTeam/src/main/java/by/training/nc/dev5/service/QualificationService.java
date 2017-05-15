package by.training.nc.dev5.service;

import by.training.nc.dev5.dto.QualificationDto;

import java.util.Collection;

/**
 * Created by Nikita on 09.05.2017.
 */
public interface QualificationService {
    Collection<QualificationDto> getQualifications();

    void createQualification(QualificationDto qualification);

    QualificationDto getQualification(int id);
}
