package by.training.nc.dev5.dao.factory;

import by.training.nc.dev5.beans.test.Question;
import by.training.nc.dev5.beans.test.Test;
import by.training.nc.dev5.beans.test.Option;
import by.training.nc.dev5.beans.users.Student;
import by.training.nc.dev5.beans.users.Tutor;
import by.training.nc.dev5.dao.InterfaceDAO;

public class OracleDAOFactory extends DAOFactory{
    @Override
    public InterfaceDAO<Student> getStudentDAO() {
        return null;
    }

    @Override
    public InterfaceDAO<Tutor> getTutorDAO() {
        return null;
    }

    @Override
    public InterfaceDAO<Test> getTestDAO() {
        return null;
    }

    @Override
    public InterfaceDAO<Question> getQuestionDAO() {
        return null;
    }

    @Override
    public InterfaceDAO<Option> getVariantDAO() {
        return null;
    }
}
