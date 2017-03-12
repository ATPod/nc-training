/**
 * 
 */
package employee.training.test;

import employee.training.dao.EmployeeDAO;
import employee.training.dao.factory.DAOFactory;


/**
 * @author GEG.BY
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
