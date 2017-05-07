package by.training.nc.dev5.service;

import by.training.nc.dev5.dao.DaoFactory;
import by.training.nc.dev5.dao.QualificationDao;
import by.training.nc.dev5.entity.Qualification;
import by.training.nc.dev5.exception.DataAccessException;

import java.util.Collection;

/**
 * Created by F1 on 05.04.2017.
 */
public class HelpService {
    private static final HelpService INSTANCE = new HelpService();
    private final DaoFactory daoFactory = 
            DaoFactory.getDaoFactory();
    
    public Collection<Qualification> getQualifications() {
        QualificationDao qualificationDao = daoFactory.getQualificationDao();

        try {
            return qualificationDao.getAll();
        } catch (DataAccessException e) {
            e.printStackTrace();
            // TODO: 05.04.2017
        }

        return null;
    }

    public Qualification getQualification(int id) {
        QualificationDao qualificationDao = daoFactory.getQualificationDao();

        try {
            return qualificationDao.getEntityById(id);
        } catch (DataAccessException e) {
            e.printStackTrace();
            // TODO: 05.04.2017
        }

        return null;
    }

    public static HelpService getInstance() {
        return INSTANCE;
    }}
