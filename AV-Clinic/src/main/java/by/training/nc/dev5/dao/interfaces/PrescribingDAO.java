package by.training.nc.dev5.dao.interfaces;

import by.training.nc.dev5.beans.patient.prescribing.Prescribing;

import java.util.List;

/**
 * Created by user on 31.03.2017.
 */
public interface PrescribingDAO{

    List<? extends Prescribing> getByPatientId(int patientId);

    void add(String s, int patientId);

    void delete(int id);
}
