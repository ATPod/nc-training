package by.training.nc.dev5.dao;

import by.training.nc.dev5.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.dao.interfaces.ProcedureDAO;
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
public class ProcedureMySQLDAO implements ProcedureDAO{
    private static final String SQL = "select id, name, patientId from procedure";
    // logger for the class
    static Logger log = Logger.getLogger(PatientMySQLDAO.class);

    public ProcedureMySQLDAO() {

    }

    public List<Procedure> selectPrescribings(int patientId) {
        Connection connection=null;
        PreparedStatement ptmt=null;
        try {
            List<Procedure> procedures = new ArrayList<Procedure>();
            Procedure procedureBean;
            connection = MySQLDAOFactory.getConnection();
            ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                if(rs.getInt(3)==patientId) {
                    procedureBean = new Procedure();
                    procedureBean.setId(rs.getInt(1));
                    procedureBean.setName(rs.getString(2));
                    procedureBean.setPatientId(rs.getInt(3));
                    procedures.add(procedureBean);
                }
            }
            return procedures;
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
