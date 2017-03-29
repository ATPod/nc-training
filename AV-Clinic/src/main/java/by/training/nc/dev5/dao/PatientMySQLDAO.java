package by.training.nc.dev5.dao;
import java.sql.*;
import java.util.*;

import by.training.nc.dev5.dao.interfaces.PatientDAO;
import org.apache.log4j.Logger;
import by.training.nc.dev5.beans.patient.Patient;
import by.training.nc.dev5.factory.MySQLDAOFactory;
/**
 * Created by user on 28.03.2017.
 */
public class PatientMySQLDAO implements PatientDAO {

    private static final String SQL = "select id, name from patient";
    // logger for the class
    static Logger log = Logger.getLogger(PatientMySQLDAO.class);

    public PatientMySQLDAO() {

    }


    public boolean deletePatient(int patientId) {
        // TODO Auto-generated method stub
        return false;
    }


    public Patient findPatient(int PatientId) {
        // TODO Auto-generated method stub
        return null;
    }

    public int insertPatient(Patient patient) {
        // TODO Auto-generated method stub
        return 0;
    }


    public List<Patient> selectPatients() {
        try {
            List<Patient> patients = new ArrayList<Patient>();
            Patient patientBean;
            Connection connection = MySQLDAOFactory.getConnection();
            PreparedStatement ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                patientBean = new Patient();
                patientBean.setId(rs.getInt(1));
                patientBean.setName(rs.getString(2));
                patients.add(patientBean);
                log.debug("Patient.id:" + patientBean.getId() +
                        " Patient.Name:" + patientBean.getName());
            }
            return patients;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return Collections.emptyList();
        }
    }


    public boolean updatePatient(int patientId) {
        // TODO Auto-generated method stub
        return false;
    }
}
