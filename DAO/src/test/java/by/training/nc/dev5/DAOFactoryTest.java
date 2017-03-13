/**
 * 
 */
package by.training.nc.dev5;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;


/**
 * @author Andrei Tishkovski
 *
 */
public class DAOFactoryTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DAOFactory mySQLDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmployeeDAO employee = mySQLDAOFactory.getEmpoyeeDAO();
		System.out.println(employee.selectEmployees().size());
	}

}
