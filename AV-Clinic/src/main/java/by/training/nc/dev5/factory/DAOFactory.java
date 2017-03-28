package by.training.nc.dev5.factory;

import by.training.nc.dev5.dao.interfaces.*;

/**
 * Created by user on 28.03.2017.
 */
public abstract class DAOFactory {
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract PatientDAO getPatientDAO();
    public abstract DiagnosisDAO getDiagnosisDAO();
    public abstract DrugDAO getDrugDAO();
    public abstract ProcedureDAO getProcedureDAO();
    public abstract SurgeryDAO getSurgeryDAO();

    public static DAOFactory getDAOFactory(
            int whichFactory) {

        switch (whichFactory) {
            case MYSQL:
                return new MySQLDAOFactory();//MySQLDAOFactory.getInstance();
            case ORACLE:
                return null;//new OracleDAOFactory();//OracleDAOFactory.getInstance();
            default:
                return null;
        }
    }
}
