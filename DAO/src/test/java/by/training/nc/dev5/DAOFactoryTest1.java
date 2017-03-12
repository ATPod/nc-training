/**
 * 
 */
package employee.training.test;

import org.apache.log4j.Logger;

import employee.training.dao.EmployeeDAO;
import employee.training.dao.factory.DAOFactory;

/**
 * @author Andrei Tishkovski
 * 
 */
public class DAOFactoryTest1 {
	static Logger logger = Logger.getLogger(DAOFactoryTest1.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmployeeDAO employee = mySQLDAOFactory.getEmpoyeeDAO();
		logger.debug("Total Records Count:" + employee.selectEmployees().size());
	}

}
