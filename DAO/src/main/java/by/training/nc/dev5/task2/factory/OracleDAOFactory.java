/**
 * 
 */
package by.training.nc.dev5.task2.factory;

import by.training.nc.dev5.task2.dao.EmployeeDAO;
import by.training.nc.dev5.task2.dao.TrainingDAO;
import by.training.nc.dev5.task2.util.PropertiesUtil;

/**
 * @author Andrei Tishkovski
 *
 */
public class OracleDAOFactory extends DAOFactory {
	
	private static OracleDAOFactory daoFactory = null; 

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.task2.factory.DAOFactory#getEmpoyeeDAO()
	 */
	@Override
	public EmployeeDAO getEmpoyeeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see by.training.nc.dev5.task2.factory.DAOFactory#getTrainingDAO()
	 */
	@Override
	public TrainingDAO getTrainingDAO() {
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
