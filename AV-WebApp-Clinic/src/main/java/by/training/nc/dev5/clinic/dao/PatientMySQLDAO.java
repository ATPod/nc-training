package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.beans.patient.Patient;
import by.training.nc.dev5.clinic.connectionpool.ConnectionPool;
import by.training.nc.dev5.clinic.constants.ColumnNames;
import by.training.nc.dev5.clinic.constants.SqlRequests;
import by.training.nc.dev5.clinic.dao.interfaces.PatientDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  PatientMySQLDAO implements PatientDAO{
    INSTANCE;
    public List<Patient> getAll(){
        List<Patient> patients = new ArrayList<Patient>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.GET_ALL_PATIENTS);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Patient temp = new Patient();
                temp.setId(resultSet.getInt(ColumnNames.PATIENT_ID));
                temp.setName(resultSet.getString(ColumnNames.PATIENT_NAME));
                patients.add(temp);
            }
        } catch (SQLException e) {
            ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                ClinicLogger.INSTANCE.logError(getClass(), e.getMessage());
            }
            ConnectionPool.putback(cn);
        }
        return patients;
    }

}
