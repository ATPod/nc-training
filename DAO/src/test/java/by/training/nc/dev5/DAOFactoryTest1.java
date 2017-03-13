/**
 * 
 */
package by.training.nc.dev5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;

/**
 * @author Andrei Tishkovski
 * 
 */
public class DAOFactoryTest1 {
	static Logger logger = LogManager.getLogger(DAOFactoryTest1.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmployeeDAO employee = mySQLDAOFactory.getEmpoyeeDAO();
		logger.debug("Total Records Count:" + employee.selectEmployees().size());
	}

}
