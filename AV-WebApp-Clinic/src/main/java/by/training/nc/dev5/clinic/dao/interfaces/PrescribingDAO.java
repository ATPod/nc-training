package by.training.nc.dev5.clinic.dao.interfaces;

import by.training.nc.dev5.clinic.beans.Entity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public interface PrescribingDAO <T extends Entity>  {

    void add(String s, int patientId) throws SQLException;
    List<T> getByPatientId(int patientId) throws SQLException;
    void delete(int id) throws SQLException;
}
