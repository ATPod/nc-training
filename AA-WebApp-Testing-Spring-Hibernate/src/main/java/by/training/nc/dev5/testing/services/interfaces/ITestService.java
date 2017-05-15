package by.training.nc.dev5.testing.services.interfaces;


import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.entities.test.Test;

import java.util.List;

public interface ITestService extends IService<Test> {
    List<Test> getTestsByName(String testName) throws DaoException;
    List<Test> getTestsBySubject(String subject) throws DaoException;

}
