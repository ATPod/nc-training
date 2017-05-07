package by.training.nc.dev5.unit3.dao;

import by.training.nc.dev5.unit3.model.Employee;

import java.util.List;

/**
 * @author Andrei Tishkovski
 */
public interface EmployeeDAO {
    void saveEmployee(Employee pEmployee);
    void deleteEmployee(String pEmployee);
    Employee findById(int pEmployeeId);
    List<Employee> findAll();
}
