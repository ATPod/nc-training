package by.training.nc.dev5.dao;

import java.sql.*;
import java.util.*;
import by.training.nc.dev5.dao.interfaces.*;
import by.training.nc.dev5.utils.ConnectionPool;
import org.apache.log4j.Logger;
import by.training.nc.dev5.beans.patient.Patient;

/**
 * Created by user on 28.03.2017.
 */
public class PatientMySQLDAO implements PatientDAO {

    static Logger log = Logger.getLogger(PatientMySQLDAO.class);
    private static final String SQL_QUERY_GET_ALL = "SELECT * FROM patient";
    private static final String SQL_QUERY_INSERT = "INSERT INTO patient (name) VALUES(?)";
    private static final String SQL_QUERY_DELETE = "DELETE FROM patient WHERE id=?";
    private static final String SQL_QUERY_GET_BY_ID = "SELECT * FROM patient WHERE id=?";

    public void add(String name){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_INSERT);
            st.setString(1, name);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
            ConnectionPool.putback(cn);
        }
    }

    public void delete(int patientId){
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_DELETE);
            st.setInt(1, patientId);
            st.executeUpdate();
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
            ConnectionPool.putback(cn);
        }
    }

    public List<Patient> getAll(){
        List<Patient> patients = new ArrayList<Patient>();
        Patient temp;
        Connection cn = null;
        Statement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.createStatement();
            ResultSet resultSet = st.executeQuery(SQL_QUERY_GET_ALL);
            while (resultSet.next()) {
                temp = new Patient();
                temp.setId(resultSet.getInt(1));
                temp.setName(resultSet.getString(2));
                temp.setDiagnosises(new DiagnosisMySQLDAO().getByPatientId(temp.getId()) );
                temp.setDrugs(new DrugMySQLDAO().getByPatientId(temp.getId()));
                temp.setProcedures(new ProcedureMySQLDAO().getByPatientId(temp.getId()));
                temp.setSurgeries(new SurgeryMySQLDAO().getByPatientId(temp.getId()));
                patients.add(temp);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
            ConnectionPool.putback(cn);
        }
        return patients;
    }

    public Patient getById(int patientId) {
        Patient patient = new Patient();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_GET_BY_ID);
            st.setInt(1, patientId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                patient.setId(resultSet.getInt("id"));
                patient.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
            ConnectionPool.putback(cn);
        }
        return patient;
    }
}
