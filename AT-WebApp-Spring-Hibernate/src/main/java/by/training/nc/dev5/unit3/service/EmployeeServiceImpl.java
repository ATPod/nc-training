package by.training.nc.dev5.unit3.service;

import by.training.nc.dev5.unit3.dao.EmployeeDAO;
import by.training.nc.dev5.unit3.dto.EmployeeDTO;
import by.training.nc.dev5.unit3.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrei Tishkovski
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<EmployeeDTO> getEmployee() {
        List<Employee> employeeList = employeeDAO.findAll();
        List<EmployeeDTO> result = new ArrayList<EmployeeDTO>(employeeList.size());
        EmployeeDTO dto;
        for (Employee item:employeeList){
            dto = new EmployeeDTO();
            dto.setFirstName(item.getFirstName());
            dto.setLastName(item.getLastName());
            result.add(dto);
        }
        return result;
    }
}
