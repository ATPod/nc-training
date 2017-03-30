package by.training.nc.dev5.dao.interfaces;



import by.training.nc.dev5.beans.patient.prescribing.Diagnosis;

import java.util.List;

/**
 * Created by user on 28.03.2017.
 */
public interface DiagnosisDAO {
    /*int insertPrescribing(Prescribing prescribing);
    boolean deletePrescribing(int prescribingId);
    Prescribing findPrescribing(int prescribingId);
    boolean updatePrescribing(int prescribingId);*/
    List<Diagnosis> selectPrescribings(int patientId);
}
