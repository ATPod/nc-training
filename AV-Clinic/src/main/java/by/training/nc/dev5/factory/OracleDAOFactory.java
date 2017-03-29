package by.training.nc.dev5.factory;

/**
 * Created by user on 28.03.2017.
 */
import by.training.nc.dev5.beans.patient.prescribing.Diagnosis;
import by.training.nc.dev5.dao.interfaces.*;

public class OracleDAOFactory extends DAOFactory {
    private static OracleDAOFactory daoFactory = null;


    @Override
    public PatientDAO getPatientDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DiagnosisDAO getDiagnosisDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DrugDAO getDrugDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProcedureDAO getProcedureDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SurgeryDAO getSurgeryDAO() {
        // TODO Auto-generated method stub
        return null;
    }

    private OracleDAOFactory(){

    }

    public static synchronized OracleDAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new OracleDAOFactory();
        }
        return daoFactory;
    }

}
