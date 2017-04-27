package by.training.nc.dev5.unit2.service;

import by.training.nc.dev5.unit2.dao.EmployeeDAO;
import by.training.nc.dev5.unit2.factory.DAOFactory;
import by.training.nc.dev5.unit2.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ants0716 on 13.04.2017.
 */
public class EmployeeService {
    public List<Employee> getEmployees() {
        DAOFactory mySqlDAOFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        EmployeeDAO employeeDAO = mySqlDAOFactory.getEmpoyeeDAO();
        List<Employee> result = new ArrayList<Employee>(0);
        if (employeeDAO != null) {
            for (Employee item : employeeDAO.selectEmployees()) {
                result.add(item);
            }
        }
        return result;
    }
}
