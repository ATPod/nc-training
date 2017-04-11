package by.training.nc.dev5.clinic.dao;

import by.training.nc.dev5.clinic.connectionpool.ConnectionPool;
import by.training.nc.dev5.clinic.logger.ClinicLogger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by user on 07.04.2017.
 */
public class PrescribingMySQLDAO {

    public void add(String name, int patientId, String query) {
        {
            Connection cn = null;
            PreparedStatement st = null;
            try {
                cn = ConnectionPool.retrieve();
                st = cn.prepareStatement(query);
                st.setString(1, name);
                st.setInt(2, patientId);
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

    public void delete(int id, String query){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(query);
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
