package by.training.nc.dev5.dao.interfaces;

import by.training.nc.dev5.beans.patient.prescribing.Procedure;

import java.util.List;

/**
 * Created by user on 28.03.2017.
 */
public interface ProcedureDAO {
    List<Procedure> selectPrescribings();
}
