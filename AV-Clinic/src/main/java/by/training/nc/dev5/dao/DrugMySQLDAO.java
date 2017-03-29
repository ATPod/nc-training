package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Drug;
import by.training.nc.dev5.dao.interfaces.DrugDAO;
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
public class DrugMySQLDAO implements DrugDAO {
    private static final String SQL = "select id, name, patientId from drug";
    // logger for the class
    static Logger log = Logger.getLogger(PatientMySQLDAO.class);

    public DrugMySQLDAO() {

    }

    public List<Drug> selectPrescribings(int patientId) {
        Connection connection=null;
        PreparedStatement ptmt=null;
        try {
            List<Drug> drugs = new ArrayList<Drug>();
            Drug drugBean;
            connection = MySQLDAOFactory.getConnection();
            ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt(3)==patientId) {
                    drugBean = new Drug();
                    drugBean.setId(rs.getInt(1));
                    drugBean.setName(rs.getString(2));
                    drugBean.setPatientId(rs.getInt(3));
                    drugs.add(drugBean);
                }
            }
            return drugs;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return Collections.emptyList();
        }finally {
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
