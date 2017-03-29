package by.training.nc.dev5.dao;
import java.sql.*;
import java.util.*;

import by.training.nc.dev5.beans.patient.prescribing.*;
import by.training.nc.dev5.dao.interfaces.*;
import by.training.nc.dev5.factory.DAOFactory;
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
        Connection connection=null;
        PreparedStatement ptmt=null;
        try {
            DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            DiagnosisDAO diagnosisDAO = mySqlDAOFactory.getDiagnosisDAO();
            DrugDAO drugDAO = mySqlDAOFactory.getDrugDAO();
            ProcedureDAO procedureDAO = mySqlDAOFactory.getProcedureDAO();
            SurgeryDAO surgeryDAO = mySqlDAOFactory.getSurgeryDAO();

            List<Patient> patients = new ArrayList<Patient>();
            Patient patientBean;
            connection = MySQLDAOFactory.getConnection();
            ptmt = connection.prepareStatement(SQL);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                patientBean = new Patient();
                patientBean.setId(rs.getInt(1));
                patientBean.setName(rs.getString(2));
                List<Diagnosis> diagnosises = diagnosisDAO.selectPrescribings(patientBean.getId());
                List<Drug> drugs = drugDAO.selectPrescribings(patientBean.getId());
                List<Procedure> procedures = procedureDAO.selectPrescribings(patientBean.getId());
                List<Surgery> surgeries = surgeryDAO.selectPrescribings(patientBean.getId());

                patientBean.setDiagnosises(diagnosises);
                patientBean.setDrugs(drugs);
                patientBean.setProcedures(procedures);
                patientBean.setSurgeries(surgeries);
                patients.add(patientBean);
            }
            return patients;
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


    public boolean updatePatient(int patientId) {
        // TODO Auto-generated method stub
        return false;
    }
}
