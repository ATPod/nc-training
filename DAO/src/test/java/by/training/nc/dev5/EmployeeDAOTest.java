/**
 * 
 */
package by.training.nc.dev5;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;
import junit.framework.TestCase;

/**
 * @author Andrei Tishkovski
 * 
 */
public class EmployeeDAOTest extends TestCase {

	private DAOFactory mMySQLDAOFactory;
	
	private EmployeeDAO mEmployee;
	
	public EmployeeDAOTest(String name) {
		super(name);
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		mMySQLDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		mEmployee = mMySQLDAOFactory.getEmpoyeeDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test returns collection of employees
	 */
	public void testSelectEmployees() {
		assertEquals(12, mEmployee.selectEmployees().size());
	}
}
