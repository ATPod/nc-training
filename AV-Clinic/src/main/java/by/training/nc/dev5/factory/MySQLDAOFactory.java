package by.training.nc.dev5.factory;

/**
 * Created by user on 28.03.2017.
 */
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;

import by.training.nc.dev5.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.beans.patient.prescribing.Procedure;
import by.training.nc.dev5.dao.*;
import by.training.nc.dev5.dao.interfaces.*;
import by.training.nc.dev5.utils.PropertiesUtil;
import org.apache.commons.dbcp.BasicDataSource;
public class MySQLDAOFactory extends DAOFactory {
    //Constants

    private static final String MYSQL_CONFIG_PROPERTIES = "mysql.properties";
    private static final String DRIVER_CLASS_NAME = "driverClassName";
    private static final String CONNECTION_URL = "connectionUrl";
    private static final String USER = "user";
    private static final String PASSWORD = "password";
    private static BasicDataSource mDatasource;

    //Members

    //Properties

    /**
     * MySQL DAO Factory constructor
     */
    public MySQLDAOFactory() {
        Properties mySQLproperties = new PropertiesUtil().getProperties(MYSQL_CONFIG_PROPERTIES);
        mDatasource = new BasicDataSource();
        mDatasource.setDriverClassName(mySQLproperties.getProperty(DRIVER_CLASS_NAME));
        mDatasource.setUrl(mySQLproperties.getProperty(CONNECTION_URL));
        mDatasource.setUsername(mySQLproperties.getProperty(USER));
        mDatasource.setPassword(mySQLproperties.getProperty(PASSWORD));
    }

    //Methods


    public static Connection getConnection() throws SQLException {
        return mDatasource.getConnection();
    }
    /**
     * Returns factory instance
     */
    public PatientDAO getPatientDAO() {
        return new PatientMySQLDAO();
    }

    public DiagnosisDAO getDiagnosisDAO() {
        return new DiagnosisMySQLDAO();
    }

    public DrugDAO getDrugDAO() {
        return new DrugMySQLDAO();
    }

    public ProcedureDAO getProcedureDAO() {
        return new ProcedureMySQLDAO();
    }

    public SurgeryDAO getSurgeryDAO() {
        return new SurgeryMySQLDAO();
    }


}
