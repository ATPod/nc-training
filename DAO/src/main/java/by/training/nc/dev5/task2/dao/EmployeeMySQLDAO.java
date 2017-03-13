/**
 * 
 */
package by.training.nc.dev5.task2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.nc.dev5.task2.model.Employee;
import by.training.nc.dev5.task2.factory.MySQLDAOFactory;

/**
 * @author Andrei_Tsishkouski
 * 
 */
public class EmployeeMySQLDAO implements EmployeeDAO {
	
	// logger for the class
	static Logger logger = LogManager.getLogger(EmployeeMySQLDAO.class);

	public EmployeeMySQLDAO() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.training.nc.dev5.dao.EmployeeDAO#deleteEmployee(java.lang.String)
	 */
	public boolean deleteEmployee(String pEmployee) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.training.nc.dev5.dao.EmployeeDAO#findEmployee(java.lang.String)
	 */
	public Employee findEmployee(String pEmployeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * by.training.nc.dev5.dao.EmployeeDAO#insertEmployee(by.training.nc.dev5.bean
	 * .Employee)
	 */
	public int insertEmployee(Employee pEmployee) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.training.nc.dev5.dao.EmployeeDAO#selectEmployees()
	 */
	public Collection<Employee> selectEmployees() {
		try {
			List<Employee> employees = new ArrayList<Employee>();
			Employee employeeBean = null;
			Connection connection = MySQLDAOFactory.getConnection();
			String querystring = "select id, first_name, last_name, email from employee";
			PreparedStatement ptmt = connection.prepareStatement(querystring);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				employeeBean = new Employee();
				employeeBean.setId(rs.getInt(1));
				employeeBean.setFirstName(rs.getString(2));
				employeeBean.setLastName(rs.getString(3));
				employeeBean.setEmail(rs.getString(4));
				employees.add(employeeBean);
				logger.debug("Employee.id:" + employeeBean.getId() + 
						" Employee.firsName:" + employeeBean.getFirstName() + 
						" Employee.lastName:" + employeeBean.getLastName() +
						" Employee.email:" + employeeBean.getEmail());
			}
			return employees;
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
			return Collections.emptyList();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.training.nc.dev5.dao.EmployeeDAO#updateEmployee(java.lang.String)
	 */
	public boolean updateEmployee(String pEmployeeId) {
		// TODO Auto-generated method stub
		return false;
	}

}
