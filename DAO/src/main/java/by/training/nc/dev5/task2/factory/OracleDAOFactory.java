/**
 * 
 */
package employee.training.dao.factory;

import employee.training.dao.EmployeeDAO;
import employee.training.dao.TrainingDAO;
import employee.training.util.PropertiesUtil;

/**
 * @author Andrei Tishkovski
 *
 */
public class OracleDAOFactory extends DAOFactory {
	
	private static OracleDAOFactory daoFactory = null; 

	/* (non-Javadoc)
	 * @see employee.training.dao.factory.DAOFactory#getEmpoyeeDAO()
	 */
	@Override
	public EmployeeDAO getEmpoyeeDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see employee.training.dao.factory.DAOFactory#getTrainingDAO()
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
