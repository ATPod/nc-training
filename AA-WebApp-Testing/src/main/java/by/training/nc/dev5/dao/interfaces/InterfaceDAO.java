package by.training.nc.dev5.dao.interfaces;

import java.util.List;

public interface InterfaceDAO <TYPE>{
        TYPE find(int id);
        boolean insert(TYPE entity);
        boolean update(TYPE entity);
        boolean delete(int entityId);
        List<TYPE> getAll();
        List<TYPE> getAll(String where, String... params);


}

