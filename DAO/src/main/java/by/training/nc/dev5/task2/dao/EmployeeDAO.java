package employee.training.dao;

import java.util.Collection;
import employee.training.bean.Employee;


public interface EmployeeDAO {
	  public int insertEmployee(Employee pEmployee);
	  public boolean deleteEmployee(String pEmployee);
	  public Employee findEmployee(String pEmployeeId);
	  public boolean updateEmployee(String pEmployeeId);
	  public Collection<Employee> selectEmployees();
}
