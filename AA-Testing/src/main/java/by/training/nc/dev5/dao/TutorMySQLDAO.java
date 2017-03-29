package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.users.Tutor;

import java.util.List;

public class TutorMySQLDAO implements InterfaceDAO<Tutor>{
    @Override
    public Tutor find(int id) {
        return null;
    }

    @Override
    public boolean insert(Tutor entity) {
        return false;
    }

    @Override
    public boolean update(Tutor entity) {
        return false;
    }

    @Override
    public boolean delete(Tutor entity) {
        return false;
    }

    @Override
    public List<Tutor> getAll(String where) {
        return null;
    }
}
