package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Test;

import java.util.List;


public class TestMySQLDAO implements InterfaceDAO<Test>{
    @Override
    public Test find(int id) {
        return null;
    }

    @Override
    public boolean insert(Test entity) {
        return false;
    }

    @Override
    public boolean update(Test entity) {
        return false;
    }

    @Override
    public boolean delete(Test entity) {
        return false;
    }

    @Override
    public List<Test> getAll(String where) {
        return null;
    }
}
