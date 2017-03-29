package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.test.Variant;

import java.util.List;


public class VariantMySQLDAO implements InterfaceDAO<Variant>{
    @Override
    public Variant find(int id) {
        return null;
    }

    @Override
    public boolean insert(Variant entity) {
        return false;
    }

    @Override
    public boolean update(Variant entity) {
        return false;
    }

    @Override
    public boolean delete(Variant entity) {
        return false;
    }

    @Override
    public List<Variant> getAll(String where) {
        return null;
    }
}
