package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Question;

import java.util.List;


public class QuestionMySQLDAO implements InterfaceDAO<Question>
{
    @Override
    public Question find(int id) {
        return null;
    }

    @Override
    public boolean insert(Question entity) {
        return false;
    }

    @Override
    public boolean update(Question entity) {
        return false;
    }

    @Override
    public boolean delete(Question entity) {
        return false;
    }

    @Override
    public List<Question> getAll(String where) {
        return null;
    }
}
