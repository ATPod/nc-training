package by.training.nc.dev5.unit2.dao;

import java.util.Collection;
import by.training.nc.dev5.unit2.model.Employee;


public interface EmployeeDAO {
	  int insertEmployee(Employee pEmployee);
	  boolean deleteEmployee(String pEmployee);
	  Employee findEmployee(String pEmployeeId);
	  boolean updateEmployee(String pEmployeeId);
	  Collection<Employee> selectEmployees();
}
