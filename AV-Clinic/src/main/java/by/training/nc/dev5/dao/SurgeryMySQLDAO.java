package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Surgery;
import by.training.nc.dev5.dao.interfaces.SurgeryDAO;
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
public class SurgeryMySQLDAO implements SurgeryDAO{
    private static final String SQL = "select id, name, patientId from surgery";
    // logger for the class
    static Logger log = Logger.getLogger(PatientMySQLDAO.class);

    public SurgeryMySQLDAO() {

    }

    public List<Surgery> selectPrescribings() {
        try {
            List<Surgery> surgeries = new ArrayList<Surgery>();
            Surgery surgeryBean;
            Connection connection = MySQLDAOFactory.getConnection();
            PreparedStatement ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                surgeryBean = new Surgery();
                surgeryBean.setId(rs.getInt(1));
                surgeryBean.setName(rs.getString(2));
                surgeryBean.setPatientId(rs.getInt(3));
                surgeries.add(surgeryBean);
            }
            return surgeries;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return Collections.emptyList();
        }
    }
}
