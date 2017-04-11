package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.connectionpool.ConnectionPool;
import by.training.nc.dev5.clinic.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.clinic.constants.ColumnNames;
import by.training.nc.dev5.clinic.constants.SqlRequests;
import by.training.nc.dev5.clinic.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.clinic.logger.ClinicLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 06.04.2017.
 */
public enum  ProcedureMySQLDAO implements PrescribingDAO<Procedure> {
    INSTANCE;

    public List<Procedure> getByPatientId(int patientId){
        List<Procedure> procedures = null;
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SqlRequests.GET_PROCEDURES_BY_PATIENT);
            st.setInt(1, patientId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Procedure temp = new Procedure();
                temp.setId(resultSet.getInt(ColumnNames.PRESCRIBING_ID));
                temp.setName(resultSet.getString(ColumnNames.PRESCRIBING_NAME));
                temp.setPatientId(resultSet.getInt(ColumnNames.PRESCRIBING_PATIENT_ID));
                procedures.add(temp);
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
        return procedures;
    }

    public void add(String name, int patientId){
        PrescribingMySQLDAO prescribingMySQLDAO = new PrescribingMySQLDAO();
        prescribingMySQLDAO.add(name, patientId, SqlRequests.INSERT_PROCEDURE);
    }

    public void delete(int id){
        PrescribingMySQLDAO prescribingMySQLDAO = new PrescribingMySQLDAO();
        prescribingMySQLDAO.delete(id, SqlRequests.DELETE_PROCEDURE);
    }
}
