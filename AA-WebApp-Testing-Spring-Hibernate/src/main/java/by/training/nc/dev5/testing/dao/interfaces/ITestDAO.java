package by.training.nc.dev5.testing.dao.interfaces;

import by.training.nc.dev5.testing.dao.exceptions.DaoException;
import by.training.nc.dev5.testing.entities.test.Test;

import java.util.List;
public interface ITestDAO extends IDAO<Test>{
    List<Test> getAllByName(String testName) throws DaoException;
    List<Test> getAllBySubject(String subject) throws DaoException;
}
