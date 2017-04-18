package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.connectionpool.ConnectionPool;
import by.training.nc.dev5.clinic.beans.patient.prescribing.Drug;
import by.training.nc.dev5.clinic.constants.ColumnNames;
import by.training.nc.dev5.clinic.constants.SqlRequests;
import by.training.nc.dev5.clinic.dao.interfaces.PrescribingDAO;
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
public enum  DrugMySQLDAO implements PrescribingDAO<Drug> {
    INSTANCE;

    public List<Drug> getByPatientId(int patientId){
        List<Drug> drugs = new ArrayList<Drug>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.GET_DRUGS_BY_PATIENT);
            st.setInt(1, patientId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Drug temp = new Drug();
                temp.setId(resultSet.getInt(ColumnNames.PRESCRIBING_ID));
                temp.setName(resultSet.getString(ColumnNames.PRESCRIBING_NAME));
                temp.setPatientId(resultSet.getInt(ColumnNames.PRESCRIBING_PATIENT_ID));
                drugs.add(temp);
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
        return drugs;
    }

    public void add(Drug temp){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.ADD_DRUG);
            st.setString(1, temp.getName());
            st.setInt(2, temp.getPatientId());
            st.executeUpdate();
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
    }

    public void delete(int id){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.DELETE_DRUG);
            st.setInt(1, id);
            st.executeUpdate();
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
    }
}
