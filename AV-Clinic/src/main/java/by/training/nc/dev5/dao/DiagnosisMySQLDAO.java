package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.dao.interfaces.DiagnosisDAO;
import by.training.nc.dev5.factory.MySQLDAOFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 28.03.2017.
 */
public class DiagnosisMySQLDAO implements DiagnosisDAO {
    private static final String SQL = "select id, name, patientId from diagnosis";
    // logger for the class
    static Logger log = Logger.getLogger(PatientMySQLDAO.class);

    public DiagnosisMySQLDAO() {

    }

    public List<Diagnosis> selectPrescribings(int patientId) {
        Connection connection=null;
        PreparedStatement ptmt=null;
        try {
            List<Diagnosis> diagnosises = new ArrayList<Diagnosis>();
            Diagnosis diagnosisBean;
            connection = MySQLDAOFactory.getConnection();
            ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt(3)==patientId){
                    diagnosisBean = new Diagnosis();
                    diagnosisBean.setId(rs.getInt(1));
                    diagnosisBean.setName(rs.getString(2));
                    diagnosisBean.setPatientId(rs.getInt(3));
                    diagnosises.add(diagnosisBean);
                }
            }
            return diagnosises;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return Collections.emptyList();
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
            } catch (SQLException ex) {
                log.error(ex.getMessage());
            }
        }
    }

}
