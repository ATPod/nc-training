package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Drug;
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
public class DrugMySQLDAO implements PrescribingDAO {

    static Logger log = Logger.getLogger(DrugMySQLDAO.class);
    private static final String SQL_QUERY_GET_BY_PATIENT = "SELECT * FROM drug WHERE patientid=?";
    private static final String SQL_QUERY_INSERT = "INSERT INTO drug (name, patientId) VALUES(?, ?)";
    private static final String SQL_QUERY_DELETE = "DELETE FROM drug WHERE id=?";

    public List<Drug> getByPatientId(int patientId) {
        List<Drug> drugs = new ArrayList<Drug>();
        Connection cn = null;
        PreparedStatement st = null;
        try {
            cn = ConnectionPool.retrieve();
            st = cn.prepareStatement(SQL_QUERY_GET_BY_PATIENT);
            st.setInt(1, patientId);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Drug temp = new Drug();
                temp.setId(resultSet.getInt("id"));
                temp.setName(resultSet.getString("name"));
                temp.setPatientId(resultSet.getInt("patientId"));
                drugs.add(temp);
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
        return drugs;
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
