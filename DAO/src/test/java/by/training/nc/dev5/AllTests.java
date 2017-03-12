package employee.training.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for employee.training.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(EmployeeDAOTest.class);
		//$JUnit-END$
		return suite;
	}

}
