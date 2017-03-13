package by.training.nc.dev5.task2.dao;

import java.util.Collection;
import by.training.nc.dev5.task2.model.Employee;


public interface EmployeeDAO {
	  public int insertEmployee(Employee pEmployee);
	  public boolean deleteEmployee(String pEmployee);
	  public Employee findEmployee(String pEmployeeId);
	  public boolean updateEmployee(String pEmployeeId);
	  public Collection<Employee> selectEmployees();
}
