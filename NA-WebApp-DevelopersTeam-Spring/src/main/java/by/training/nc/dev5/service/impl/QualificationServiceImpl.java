package by.training.nc.dev5.service.impl;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.dao.persistence.JpaDaoFactory;
import by.training.nc.dev5.dto.QualificationDto;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.exception.DataAccessException;
import by.training.nc.dev5.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Nikita on 09.05.2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DataAccessException.class)
public class QualificationServiceImpl implements QualificationService {
    private final QualificationDao qualificationDao;

    @Autowired
    public QualificationServiceImpl(QualificationDao qualificationDao) {
        this.qualificationDao = qualificationDao;
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Collection<QualificationDto> getQualifications() {
        Collection<Qualification> all = qualificationDao.getAll();
        Collection<QualificationDto> result =
                new ArrayList<QualificationDto>(all.size());

        for (Qualification q : all) {
            result.add(createQualificationDto(q));
        }

        return result;
    }

    private QualificationDto createQualificationDto(
            Qualification qualification) {

        QualificationDto dto = new QualificationDto();

        dto.setId(qualification.getId());
        dto.setName(qualification.getName());

        return dto;
    }

    public void createQualification(QualificationDto dto) {
        Qualification q = new Qualification();

        q.setId(dto.getId());
        q.setName(dto.getName());

        qualificationDao.create(q);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public QualificationDto getQualification(int id) {
        return createQualificationDto(qualificationDao.getEntityById(id));
    }
}
