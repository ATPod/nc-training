package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.beans.patient.prescribing.Prescribing;
import by.training.nc.dev5.dao.interfaces.PrescribingDAO;
import by.training.nc.dev5.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 28.03.2017.
 */
public class DiagnosisMySQLDAO implements PrescribingDAO {

    static Logger log = Logger.getLogger(DiagnosisMySQLDAO.class);
    private static final String SQL_QUERY_GET_BY_PATIENT = "SELECT * FROM diagnosis WHERE patientid=?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO diagnosis (name, patientId) VALUES(?, ?)";
    private static final String SQL_QUERY_DELETE = "DELETE FROM diagnosis WHERE id=?";

    public List<Diagnosis> getByPatientId(int patientId){
        List<Diagnosis> diagnosises = new ArrayList<Diagnosis>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_GET_BY_PATIENT);
            st.setInt(1, patientId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Diagnosis temp = new Diagnosis();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setPatientId(resultSet.getInt("patientId"));
                diagnosises.add(temp);
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
        return diagnosises;
    }

    public void add(String name, int patientId){
        PrescribingMySQLDAO prescribingMySQLDAO = new PrescribingMySQLDAO();
        prescribingMySQLDAO.setSQL_QUERY_INSERT(SQL_QUERY_INSERT);
        prescribingMySQLDAO.add(name, patientId);
    }

    public void delete(int id){
        PrescribingMySQLDAO prescribingMySQLDAO = new PrescribingMySQLDAO();
        prescribingMySQLDAO.setSQL_QUERY_DELETE(SQL_QUERY_DELETE);
        prescribingMySQLDAO.delete(id);
    }

}
