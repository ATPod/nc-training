package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.beans.Entity;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by user on 04.04.2017.
 */
public interface AbstractDAO <T extends Entity> {
    List<T> findAll() throws SQLException;
    public void createEntity(T entity) throws SQLException;
    public T getEntityById(int id) throws SQLException;
}
