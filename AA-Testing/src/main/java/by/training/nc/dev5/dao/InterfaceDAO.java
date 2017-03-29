package by.training.nc.dev5.dao;

import java.util.List;

public interface InterfaceDAO <TYPE>{
        TYPE find(int id);
        boolean insert(TYPE entity);
        boolean update(TYPE entity);
        boolean delete(TYPE entity);
        List<TYPE> getAll(String where);
    }

